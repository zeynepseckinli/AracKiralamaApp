package com.zeynep.service;

import com.zeynep.repository.KiralamaRepository;
import com.zeynep.repository.entity.Kiralama;
import com.zeynep.repository.views.KiralamaSayisi;
import com.zeynep.repository.views.KiralananAraclar;
import com.zeynep.utility.MyFactoryService;

import java.util.List;

public class KiralamaService extends MyFactoryService<KiralamaRepository, Kiralama,Long> {
    KiralamaRepository kiralamaRepository;
    public KiralamaService() {
        super(new KiralamaRepository());
        this.kiralamaRepository=new KiralamaRepository();
    }

    public List<KiralananAraclar> raporlama() {
        return kiralamaRepository.raporlama();
    }

    public List<KiralamaSayisi> kiralamaSayisi() {
        return kiralamaRepository.kiralamaSayisi();
    }
}
