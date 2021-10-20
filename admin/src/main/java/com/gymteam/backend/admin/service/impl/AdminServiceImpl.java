package com.gymteam.backend.admin.service.impl;

import com.gymteam.backend.admin.entity.Admin;
import com.gymteam.backend.admin.exception.NotFoundException;
import com.gymteam.backend.admin.repository.AdminRepository;
import com.gymteam.backend.admin.service.interfaces.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Override
    public Admin getAdmin(UUID id) throws NotFoundException {
        Optional<Admin> customerOptional = adminRepository.findById(id);
        return customerOptional.orElseThrow(NotFoundException::new);
    }

    @Override
    public void createAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public Admin updateAdmin(Admin admin) throws NotFoundException {
        // TODO Update Method instead mapping
        if (admin.getId() == null) {
            throw new NotFoundException();
        }
        Admin existing = adminRepository.findById(admin.getId()).orElseThrow(NotFoundException::new);
        if (admin.getEmail() == null) {
            admin.setEmail(existing.getEmail());
        }
        if (admin.getPassword() == null) {
            admin.setPassword(existing.getPassword());
        }
        adminRepository.save(admin);
        return admin;
    }
}
