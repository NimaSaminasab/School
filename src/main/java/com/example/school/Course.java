package com.example.school;

import jakarta.persistence.*;

@Table
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id ;
    String name ;
    int point ;

    public Course(){}
    public Course(String name, int point) {
        this.name = name;
        this.point = point ;
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


    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
