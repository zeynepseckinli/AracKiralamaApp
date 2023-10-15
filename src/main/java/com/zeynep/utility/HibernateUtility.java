package com.zeynep.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/*
 HibernateUtility -> hivernate.cfg.xml dosyasini kullanarak connection olusturmak icin kullanilacaktir
 Istenilirse hibernate dosyasinin konumu burada belirtilerek farkli lokasyonlardan okunabilir

 JDBC driver ile baglanti olusturyoruz. Veri tabanina ekleme, okuma vrud islemleri yapiyoruz
 Hibernate bu islmeleri yapabilmek icin hangi veri tabanı ve hangi tablolari hangi entitylerle
 eslestirecegim diye soruyor. bunu yonetebilmek icin bu sınıfa ihtiyacim var.
 Sınıfı acip yoneyebilmek icin hibernate.cfg.xml dosyasina ulasiyor ve SessionFactory ye
  yukluyoruz ve baglantiyi kuruyor.
 */
public class HibernateUtility {
    private static final SessionFactory SESSION;

    static{
        try{
            //SESSION = new Configuration().configure("c:\\config\\hibernate.cfg.xml").buildSessionFactory();
            SESSION = new Configuration().configure().buildSessionFactory();
        }catch (Exception exception){
            System.out.println("Hibernate başlatılırken hata oluştu:"+ exception);
            throw new ExceptionInInitializerError(exception);
        }
    }

    public static SessionFactory getSessionFactory(){
        return SESSION;
    }
}
