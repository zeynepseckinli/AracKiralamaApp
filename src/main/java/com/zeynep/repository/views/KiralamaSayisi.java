package com.zeynep.repository.views;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class KiralamaSayisi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String marka;
    private String model;
    private BigInteger kiralamasayisi;

}
