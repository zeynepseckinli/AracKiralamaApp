package com.zeynep.repository.entity;

import com.zeynep.repository.enums.EMarka;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_arac")
public class Arac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private EMarka marka;
    private String model;
    @Builder.Default
    private boolean durum=true;
//    @OneToMany(mappedBy = "arac", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    List<Kiralama> kiralamaList;
    @Embedded
    BaseEntity baseEntity;


    @Override
    public String toString() {
        return "Arac{" +
                "id=" + id +
                ", marka=" + marka +
                ", model='" + model + '\'' +
                ", durum=" + durum +
                ", baseEntity=" + baseEntity +
                '}';
    }
}
