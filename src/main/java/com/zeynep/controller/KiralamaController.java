package com.zeynep.controller;

import com.zeynep.repository.entity.Arac;
import com.zeynep.repository.entity.Kiralama;
import com.zeynep.repository.entity.Kisi;
import com.zeynep.repository.views.KiralamaSayisi;
import com.zeynep.repository.views.KiralananAraclar;
import com.zeynep.service.KiralamaService;
import com.zeynep.utility.Constants;
import com.zeynep.utility.UtilityClass;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class KiralamaController {
    AracController aracController;
    KiralamaService kiralamaService;
    KisiController kisiController;


    public KiralamaController(){
        this.kiralamaService=new KiralamaService();
        this.aracController= new AracController();
        this.kisiController= new KisiController();
    }
    public Kiralama save(Kiralama kiralama){
        return kiralamaService.save(kiralama);
    }

    public Kiralama kiralamaYap(Kisi kisi) {
        guncelle();
        Kiralama kiralama=null;
        Boolean status = false;
        LocalDate baslangicTarihi;
        LocalDate bitisTarihi;
        System.out.println("Kiralama yapabileceğiniz araçlar : ");
        aracController.kiralamaYapilabilecekAraclar().forEach(System.out::println);
        Long id = UtilityClass.longDeger("id giriniz : ");
        Optional<Arac> arac = aracController.findById(id);
        if(arac.isPresent()){
            do {
                System.out.println("Başlangıç tarihi için;");
                int yil = UtilityClass.intDeger("Yıl : ");
                int ay = UtilityClass.intDeger("Ay : ");
                int gun = UtilityClass.intDeger("Gun : ");
                baslangicTarihi = LocalDate.of(yil, ay, gun);
                if (LocalDate.now().isAfter(baslangicTarihi)){
                    status = true;
                    System.out.println("Girdiğiniz tarih bugünün tarihinden ileri bir tarih olmalidir.");
                }
                do {
                    System.out.println("Bitiş tarihi için;");
                    int byil = UtilityClass.intDeger("Yıl : ");
                    int bay = UtilityClass.intDeger("Ay : ");
                    int bgun = UtilityClass.intDeger("Gun : ");
                    bitisTarihi = LocalDate.of(byil,bay,bgun);
                    if (baslangicTarihi.isAfter(bitisTarihi)){
                        status =true;
                        System.out.println("Bitis tarihi baslangic tarihinden erken olamaz.");
                    }
                }while (!status);
            }while (!status);
            kiralama = Kiralama.builder()
                    .arac(arac.get())
                    .kisi(kisi)
                    .baslangicTarihi(baslangicTarihi)
                    .bitisTarihi(bitisTarihi)
                    .baseEntity(Constants.getBaseEntity())
                    .build();
            arac.get().setDurum(false);
            aracController.update(arac.get());
        }
        return kiralamaService.save(kiralama);
    }

    public Kiralama kisiyeGoreKiralamaYap() {
        String username = UtilityClass.stringDeger("Lutfen usermame giriniz : ");
        Optional<Kisi> kisi =kisiController.findByUsername(username);

        if(kisi.isPresent()){
            return kiralamaYap(kisi.get());
        } else {
            System.out.println("Yeni uye olusturuluyor....");
            System.out.println();
           Kisi kisi1 = kisiController.kisiEkle();
            return kiralamaYap(kisi1);
        }


    }
    public void guncelle(){
        kiralamaService.findAll().forEach(kiralama -> {
            if (kiralama.getBitisTarihi().isBefore(LocalDate.now())){
                kiralama.getArac().setDurum(true);
                aracController.update(kiralama.getArac());
            }
        });

    }


    public List<KiralananAraclar> raporlama() {
        return kiralamaService.raporlama();
    }

    public List<KiralamaSayisi> kiralamaSayisi(){
        return kiralamaService.kiralamaSayisi();
    }
}
