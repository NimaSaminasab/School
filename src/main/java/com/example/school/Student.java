package com.example.school;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import jakarta.persistence.*;
@Table
@Entity
//@JsonIdentityInfo()
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    Long id ;
    String name ;
    Long telefon ;
    String adress ;

    public Student(){}
    public Student(String name, Long telefon, String adress) {
        this.name = name;
        this.telefon = telefon;
        this.adress = adress;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTelefon() {
        return telefon;
    }

    public void setTelefon(Long telefon) {
        this.telefon = telefon;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}