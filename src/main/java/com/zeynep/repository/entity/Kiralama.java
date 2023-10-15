package com.zeynep.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_kiralama")
public class Kiralama {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate baslangicTarihi;
    private LocalDate bitisTarihi;
    @ManyToOne
    Arac arac;
    @ManyToOne
    Kisi kisi;
    @Embedded
    BaseEntity baseEntity;
}
