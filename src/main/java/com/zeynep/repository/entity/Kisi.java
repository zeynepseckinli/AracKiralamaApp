package com.zeynep.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_kisi")
public class Kisi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false,unique = true)
    private String username;
    private String password;
    @OneToMany(mappedBy = "kisi")
    List<Kiralama> kiralamaList;
    @Embedded
    BaseEntity baseEntity;

    @Override
    public String toString() {
        return "Kisi{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", baseEntity=" + baseEntity +
                '}';
    }
}
