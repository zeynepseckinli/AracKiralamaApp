package com.zeynep.repository.views;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class KiralananAraclar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    private String marka;
    private String model;
    private boolean durum;

    private LocalDate baslangictarihi;
    private LocalDate bitistarihi;

    private String name;
    private String surname;
}
