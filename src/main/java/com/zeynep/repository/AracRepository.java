package com.zeynep.repository;

import com.zeynep.repository.entity.Arac;
import com.zeynep.utility.HibernateUtility;
import com.zeynep.utility.MyFactoryRepository;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import java.util.List;

public class AracRepository extends MyFactoryRepository<Arac,Long> {
    EntityManager entityManager;
    public AracRepository() {
        super(new Arac());
        this.entityManager= HibernateUtility.getSessionFactory().createEntityManager();
    }

    public List<Arac> kiralamaYapilabilecekAraclar() {
        String sql= "SELECT * FROM tbl_arac WHERE durum=true";
        Query query = entityManager.createNativeQuery(sql, Arac.class);
        return query.getResultList();
    }

    public List<Arac> kiradaOlanAraclar() {
        String sql= "SELECT * FROM tbl_arac WHERE durum=false";
        Query query = entityManager.createNativeQuery(sql, Arac.class);
        return query.getResultList();
    }

    public List<Arac> musteriyeGoreKiraladigiAraclar(Long id) {
        String sql = "SELECT a.* FROM tbl_arac a INNER JOIN tbl_kiralama k ON a.id=k.arac_id WHERE k.kisi_id=:ID";
        Query query=entityManager.createNativeQuery(sql, Arac.class);
        query.setParameter("ID",id);
        return query.getResultList();
    }
}
