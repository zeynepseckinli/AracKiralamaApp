package com.zeynep.utility;

import com.zeynep.controller.AdminController;
import com.zeynep.controller.AracController;
import com.zeynep.repository.entity.Admin;
import com.zeynep.repository.entity.Arac;
import com.zeynep.repository.enums.EMarka;

import java.util.List;

public class DataGenerator {
    AdminController adminController;
    AracController aracController;

    public DataGenerator() {
        this.adminController=new AdminController();
        this.aracController=new AracController();
    }
        public Admin adminOlustur(){
            Admin admin = Admin.builder()
                    .name("Admin")
                    .username("admin1")
                    .password("admin123")
                    .build();
            return adminController.save(admin);
        }

    public List<Arac> aracOlustur(){

        Arac arac = Arac.builder()
                .marka(EMarka.AUDI)
                .model("A5")
                .durum(true)
                .baseEntity(Constants.getBaseEntity())
                .build();
        Arac arac1 = Arac.builder()
                .marka(EMarka.BMW)
                .model("X5")
                .durum(true)
                .baseEntity(Constants.getBaseEntity())
                .build();

        Arac arac2 = Arac.builder()
                .marka(EMarka.AUDI)
                .model("RS8")
                .durum(true)
                .baseEntity(Constants.getBaseEntity())
                .build();

        Arac arac3 = Arac.builder()
                .marka(EMarka.BMW)
                .model("Z4")
                .durum(true)
                .baseEntity(Constants.getBaseEntity())
                .build();

        Arac arac4 = Arac.builder()
                .marka(EMarka.LAMBORGHINI)
                .model("HURACAN")
                .durum(true)
                .baseEntity(Constants.getBaseEntity())
                .build();

        Arac arac5= Arac.builder()
                .marka(EMarka.MERCEDES)
                .model("C180-AMG")
                .durum(true)
                .baseEntity(Constants.getBaseEntity())
                .build();

        Arac arac6 = Arac.builder()
                .marka(EMarka.MERCEDES)
                .model("G63")
                .durum(true)
                .baseEntity(Constants.getBaseEntity())
                .build();

        Arac arac7 = Arac.builder()
                .marka(EMarka.FIAT)
                .model("EGEA")
                .durum(true)
                .baseEntity(Constants.getBaseEntity())
                .build();

        Arac arac8 = Arac.builder()
                .marka(EMarka.RENAULT)
                .model("Megane")
                .durum(true)
                .baseEntity(Constants.getBaseEntity())
                .build();
        Arac arac9 = Arac.builder()
                .marka(EMarka.TESLA)
                .model("MODELE X")
                .durum(true)
                .baseEntity(Constants.getBaseEntity())
                .build();
        Arac arac10 = Arac.builder()
                .marka(EMarka.TOGG)
                .model("T10S C-Segment SUV")
                .durum(true)
                .baseEntity(Constants.getBaseEntity())
                .build();


        return aracController.saveAll(List.of(arac,arac1,arac2,arac3,arac4,arac5,arac6,arac7,arac8,arac9,arac10));
    }



}
