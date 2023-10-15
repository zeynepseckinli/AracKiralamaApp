package com.zeynep.repository;

import com.zeynep.repository.entity.Admin;
import com.zeynep.utility.MyFactoryRepository;

public class AdminRepository extends MyFactoryRepository<Admin,Long> {
    public AdminRepository() {
        super(new Admin());
    }
}
