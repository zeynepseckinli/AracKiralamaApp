package com.zeynep.repository;

import com.zeynep.repository.entity.Kiralama;
import com.zeynep.repository.views.KiralamaSayisi;
import com.zeynep.repository.views.KiralananAraclar;
import com.zeynep.utility.HibernateUtility;
import com.zeynep.utility.MyFactoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class KiralamaRepository extends MyFactoryRepository<Kiralama,Long> {
    EntityManager entityManager;
    public KiralamaRepository() {
        super(new Kiralama());
        this.entityManager= HibernateUtility.getSessionFactory().createEntityManager();
    }

    public List<KiralananAraclar> raporlama() {
        String sql="SELECT a.id,a.marka,a.model,a.durum,k.baslangictarihi,k.bitistarihi,ki.name,ki.surname " +
                "FROM tbl_arac a INNER JOIN tbl_kiralama k ON k.arac_id=a.id " +
                "INNER JOIN tbl_kisi ki ON k.kisi_id=ki.id";
        Query query = entityManager.createNativeQuery(sql, KiralananAraclar.class);
        return query.getResultList();

    }

    public List<KiralamaSayisi> kiralamaSayisi() {
        String sql= "SELECT a.id,a.marka,a.model, COUNT(k.id) kiralamasayisi FROM tbl_arac a INNER JOIN tbl_kiralama k ON k.arac_id=a.id GROUP BY(a.id);";
        Query query = entityManager.createNativeQuery(sql, KiralamaSayisi.class);
        return query.getResultList();
    }
}
