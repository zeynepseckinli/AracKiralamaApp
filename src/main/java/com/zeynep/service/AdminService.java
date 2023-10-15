package com.zeynep.service;

import com.zeynep.repository.AdminRepository;
import com.zeynep.repository.entity.Admin;
import com.zeynep.utility.MyFactoryService;

public class AdminService extends MyFactoryService<AdminRepository, Admin,Long> {
    public AdminService() {
        super(new AdminRepository());
    }
}
