package com.zeynep;

import com.zeynep.controller.AracController;
import com.zeynep.controller.KiralamaController;
import com.zeynep.controller.KisiController;
import com.zeynep.repository.entity.Kisi;
import com.zeynep.utility.DataGenerator;
import com.zeynep.utility.UtilityClass;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    AracController aracController;
    KisiController kisiController;
    KiralamaController kiralamaController;

    public Main() {
        this.aracController=new AracController();
        this.kiralamaController=new KiralamaController();
        this.kisiController=new KisiController();
    }

    public static void main(String[] args) {
        Main main = new Main();
        DataGenerator dataGenerator=new DataGenerator();
//        dataGenerator.adminOlustur();
//        dataGenerator.aracOlustur();
        main.uygulama();
    }

    private void uygulama() {
        boolean cikis= false;
        do {
            kiralamaController.guncelle();
            menu();
            int secim = UtilityClass.intDeger("Lutfen secim yapiniz : ");
            switch (secim){
                case 1: {
                    kisiController.kisiEkle();
                }
                break;
                case 2: {
                    kullaniciGirisi();
                }
                break;
                case 3: {
                    adminGirisi();
                }
                break;
                case 0: {
                    cikis = true;
                }
                break;
            }
        } while (!cikis);
    }

    private void adminGirisi() {
        adminMenu();

    }



    private void kullaniciGirisi() {
        String username;
        String password;
        Boolean dataIntegrity = false;
        Optional<Kisi> kisi = null;
        List<String> usernameList= kisiController.findAll().stream().map(k->k.getUsername()).collect(Collectors.toList());
        do {
            username=UtilityClass.stringDeger("Username : ");
            if (usernameList.contains(username)){
                kisi=kisiController.findByUsername(username);
                do {
                    password = UtilityClass.stringDeger("Sifre : ");
                    if(kisi.get().getPassword().equals(password)){
                        dataIntegrity=true;
                        registerMenu(kisi.get());
                    } else {
                        System.out.println("Yanlış şifre girdiniz.");
                        dataIntegrity = false;
                    }
                }while(!dataIntegrity);
            } else {
                System.out.println("Kullanıcı adınız hatalı");
                dataIntegrity=false;
            }
        }while(!dataIntegrity);
    }

    private void registerMenu(Kisi kisi) {
        boolean control = true;
        do {
            registerMenuGorunum();
            int secim = UtilityClass.intDeger("Lutfen secim yapınız : ");
            switch (secim){
                case 1: {
                    aracController.markayaGoreAracAra().forEach(System.out::println);
                }break;
                case 2: {
                    kiralamaController.kiralamaYap(kisi);
                }break;
                case 3: {
                    aracController.kisininKiraladigiAraclar(kisi).forEach(System.out::println);
                }break;
                case 4: {
                    aracController.kiralamaYapilabilecekAraclar().forEach(System.out::println);
                }break;
                case 0: {
                    control=false;
                }break;
            }
        }while(control);
    }

    private void adminMenu() {
        boolean control =true;
        do {
            adminMenuGorunum();
            int secim = UtilityClass.intDeger("Lutfen secim yapınız : ");
            switch (secim){
                case 1: {
                    aracController.aracEkle();
                }break;
                case 2: {
                    kisiController.kisiEkle();
                }break;
                case 3: {
                    aracController.markayaGoreAracAra().forEach(System.out::println);
                }break;
                case 4: {
                    kiralamaController.kisiyeGoreKiralamaYap();
                }break;
                case 5: {
                    System.out.println("-----   Araçların Kiralanma Geçmişi   -----");
                    kiralamaController.raporlama().forEach(System.out::println);
                    System.out.println("-----   Araçların Kiralanma Sayıları   -----");
                    kiralamaController.kiralamaSayisi().forEach(System.out::println);
                }break;
                case 6: {
                    aracController.kiradaOlanAraclar().forEach(System.out::println);
                }break;
                case 7: {
                    aracController.kiralamaYapilabilecekAraclar().forEach(System.out::println);
                }break;
                case 8: {
                    aracController.musteriyeGoreKiraladigiAraclar().forEach(System.out::println);
                }break;
                case 0: {
                    control=false;
                }break;
            }
        }while(control);
    }

    public void registerMenuGorunum() {
        System.out.println("*****   Araç Kiralama Uygulaması   *****");
        System.out.println("");
        System.out.println("1 - Arac Ara");
        System.out.println("2 - Kiralama Yap");
        System.out.println("3 - Kiralama Geçmişim");
        System.out.println("4 - Boşta Olan Araçlar");
        System.out.println("0 - Çıkış Yap");
        System.out.println("");
    }
    public void adminMenuGorunum() {
        System.out.println("*****   Araç Kiralama Uygulaması   *****");
        System.out.println("");
        System.out.println("1 - Arac Ekle");
        System.out.println("2 - Kisi Ekle");
        System.out.println("3 - Arac Ara");
        System.out.println("4 - Kiralama Yap");
        System.out.println("5 - Raporlama Menusu");
        System.out.println("6 - Kirada Olan Araçlar");
        System.out.println("7 - Boşta Olan Araçlar");
        System.out.println("8 - Herhangi bir müşterinin kiraladığı araçlar");
        System.out.println("0 - Çıkış Yap");
        System.out.println("");
    }

    public void menu(){
        System.out.println("*****   Araç Kiralama Uygulaması   *****");
        System.out.println("");
        System.out.println("1- Kayıt Ol");
        System.out.println("2- Kullanıcı Girişi");
        System.out.println("3- Admin Girişi");
        System.out.println("0- Çıkış Yap");
        System.out.println();
    }

}