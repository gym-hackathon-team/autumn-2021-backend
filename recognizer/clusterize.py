import pathlib
import numpy as np


class Clusters:
    def __init__(self, base_path=pathlib.Path('.')):
        self.local_radius = 0.8
        self.global_radius = 0.8

        base_path = pathlib.Path(base_path)
        self.vectors_path = base_path / pathlib.Path('vectors_matrix')
        self.cluster_path = base_path / pathlib.Path('cluster_ids')

        if self.vectors_path.is_file():
            self.all_vectors_matrix = np.loadtxt(str(self.vectors_path.absolute()), ndmin=2)
        else:
            self.all_vectors_matrix = np.empty((0, 128))

        if self.cluster_path.is_file():
            self.cluster_ids = np.loadtxt(str(self.cluster_path.absolute()), dtype=np.int, ndmin=1)
        else:
            self.cluster_ids = np.empty((0,), dtype=np.int)

        self.n = self.all_vectors_matrix.shape[0]  # total number of vectors
        self.m = self.all_vectors_matrix.shape[1]  # vector length

        self.k = np.unique(self.cluster_ids).shape[0]  # number of clusters
        self.cluster_center_matrix = np.empty((self.k, self.m))
        for i in range(self.k):
            self.cluster_center_matrix[i] = self.find_cluster_center(i)

    @staticmethod
    def norm_vector(vector):
        if vector @ vector < 1e-10:
            vector[0] = 1
        return vector / np.linalg.norm(vector)

    def find_cluster_center(self, target_cluster_id):
        cluster_sum = np.zeros((self.m,))

        for j, cluster_id in np.ndenumerate(self.cluster_ids):
            if cluster_id == target_cluster_id:
                cluster_sum += self.all_vectors_matrix[j]

        return self.norm_vector(cluster_sum)

    def add_vector_and_get_id(self, test_vector):
        normalized_test_vector = self.norm_vector(test_vector)
        cluster_id = self.get_id(normalized_test_vector)

        if cluster_id is None:
            self.cluster_center_matrix = np.append(self.cluster_center_matrix, [normalized_test_vector], axis=0)
            cluster_id = self.k
            self.k += 1

        self.cluster_ids = np.append(self.cluster_ids, [cluster_id], axis=0)
        self.all_vectors_matrix = np.append(self.all_vectors_matrix, [normalized_test_vector], axis=0)
        self.n += 1

        self.cluster_center_matrix[cluster_id] = self.find_cluster_center(cluster_id)

        np.savetxt(self.vectors_path, self.all_vectors_matrix)
        np.savetxt(self.cluster_path, self.cluster_ids, fmt='%d')

        return cluster_id

    def get_id(self, test_vector):
        if self.cluster_ids.shape[0] == 0:
            return None
        vectors_local_distance = 1 - self.all_vectors_matrix @ test_vector
        close_local_vectors = vectors_local_distance < self.local_radius
        if close_local_vectors.shape[0] == 0:
            return None
        close_local_vectors_ids = np.unique(self.cluster_ids[close_local_vectors])

        if close_local_vectors_ids.shape[0] == 0:
            return None
        suitable_centers = self.cluster_center_matrix[close_local_vectors_ids]
        suitable_centers_distance = 1 - suitable_centers @ test_vector
        close_suitable_centers = suitable_centers_distance < self.global_radius

        if close_suitable_centers.shape[0] == 0:
            return None
        suitable_cluster_ids = close_local_vectors_ids[close_suitable_centers]
        if suitable_centers_distance.shape[0] == 0:
            return None
        sorted_suitable_cluster_ids = suitable_cluster_ids[
            np.argsort(suitable_centers_distance[close_suitable_centers])]

        if sorted_suitable_cluster_ids.shape[0] > 0:
            return sorted_suitable_cluster_ids[0]
        else:
            return None
