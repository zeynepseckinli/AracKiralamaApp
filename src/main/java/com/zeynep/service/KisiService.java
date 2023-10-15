package com.zeynep.service;

import com.zeynep.repository.KisiRepository;
import com.zeynep.repository.entity.Kisi;
import com.zeynep.utility.MyFactoryService;

import java.util.Optional;

public class KisiService extends MyFactoryService<KisiRepository, Kisi,Long> {
    KisiRepository kisiRepository;
    public KisiService() {
        super(new KisiRepository());
        this.kisiRepository = new KisiRepository();
    }

    public Optional<Kisi> findByUsername(String username) {
        return kisiRepository.findByUsername(username);
    }
}
