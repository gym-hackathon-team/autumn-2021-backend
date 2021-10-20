package com.gymteam.backend.admin.repository;

import com.gymteam.backend.admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdminRepository extends JpaRepository<Admin, UUID> {
}
