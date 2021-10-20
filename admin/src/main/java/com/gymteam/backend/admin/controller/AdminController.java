package com.gymteam.backend.admin.controller;

import com.gymteam.backend.admin.dto.AdminDto;
import com.gymteam.backend.admin.entity.Admin;
import com.gymteam.backend.admin.exception.NotFoundException;
import com.gymteam.backend.admin.mapper.interfaces.AdminMapper;
import com.gymteam.backend.admin.service.interfaces.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;

    private final AdminMapper adminMapper;

    @GetMapping("/{id}")
    public ResponseEntity<AdminDto> read(@PathVariable UUID id) {
        try {
            return new ResponseEntity<>(adminMapper.convertToDto(adminService.getAdmin(id)), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<AdminDto> create(@RequestBody AdminDto dto) {
        try {
            Admin admin = adminMapper.convertToEntity(dto);
            adminService.createAdmin(admin);
            return new ResponseEntity<>(adminMapper.convertToDto(admin), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity<AdminDto> update(@RequestBody AdminDto dto) {
        try {
            Admin admin = adminService.updateAdmin(adminMapper.convertToEntity(dto));
            return new ResponseEntity<>(adminMapper.convertToDto(admin), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
