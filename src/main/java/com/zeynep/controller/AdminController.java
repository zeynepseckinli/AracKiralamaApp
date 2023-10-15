package com.zeynep.controller;

import com.zeynep.repository.entity.Admin;
import com.zeynep.service.AdminService;

public class AdminController {
    AdminService adminService;

    public AdminController() {
        this.adminService=new AdminService();
    }

    public Admin save(Admin admin) {
        return adminService.save(admin);
    }
}
