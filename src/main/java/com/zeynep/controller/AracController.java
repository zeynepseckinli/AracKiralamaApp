package com.zeynep.controller;

import com.zeynep.repository.entity.Arac;
import com.zeynep.repository.entity.Kisi;
import com.zeynep.repository.enums.EMarka;
import com.zeynep.service.AracService;
import com.zeynep.utility.Constants;
import com.zeynep.utility.UtilityClass;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AracController {
    AracService aracService;
    KisiController kisiController;

    public AracController(){
        this.aracService=new AracService();
        this.kisiController=new KisiController();
    }

    public Arac save(Arac arac){
        return aracService.save(arac);
    }

    public List<Arac> findByColumnNameAndValue(String columnName, String value) {
        return aracService.findByColumnNameAndValue(columnName,value);
    }

    public Optional<Arac> findById(Long aracId) {
        return aracService.findById(aracId);
    }

    public List<Arac> kiralamaYapilabilecekAraclar() {
        return aracService.kiralamaYapilabilecekAraclar();
    }

    public Arac aracEkle() {
        Arrays.stream(EMarka.values()).forEach(System.out::println);
        String marka = UtilityClass.stringDeger("Marka : ").toUpperCase();
        String model = UtilityClass.stringDeger("Model : ");
        Arac arac = Arac.builder()
                .marka(EMarka.valueOf(marka))
                .model(model)
                .baseEntity(Constants.getBaseEntity())
                .build();
        return aracService.save(arac);
    }

    public void update(Arac arac) {
        aracService.update(arac);
    }

    public List<Arac> markayaGoreAracAra() {
        Arrays.stream(EMarka.values()).forEach(System.out::println);
        String marka = UtilityClass.stringDeger("Aramak istediğiniz marka : ").toUpperCase();
        return aracService.findByColumnNameAndValue("marka",marka);
    }

    public List<Arac> kiradaOlanAraclar() {
        return aracService.kiradaOlanAraclar();
    }

    public List<Arac> musteriyeGoreKiraladigiAraclar() {
        String username = UtilityClass.stringDeger("Lutfen usermame giriniz : ");
        Optional<Kisi> kisi =kisiController.findByUsername(username);
        return aracService.musteriyeGoreKiraladagiAraclar(kisi.get().getId());
    }


    public List<Arac> kisininKiraladigiAraclar(Kisi kisi) {
        return aracService.musteriyeGoreKiraladagiAraclar(kisi.getId());
    }

    public List<Arac> saveAll(List<Arac> aracList) {
        return (List<Arac>) aracService.saveAll(aracList);
    }
}
