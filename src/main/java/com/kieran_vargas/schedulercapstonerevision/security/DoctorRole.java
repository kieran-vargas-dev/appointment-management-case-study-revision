package com.kieran_vargas.schedulercapstonerevision.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DoctorRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public DoctorRole() {
    }

    public DoctorRole(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "com.kieran_vargas.schedulercapstonerevision.Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
