package com.labratorij.gameshop.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "employee", schema = "gameshop_eng")
public class Employee {

    @Id
    @GenericGenerator(name = "inc", strategy = "increment")
    @GeneratedValue(generator = "inc")
    @Column(name = "Employee number")
    private int id;

    @Column(name = "Name", length = 64, nullable = false, unique = true)
    private String name;

    @Column(name = "Passport", length = 10)
    private int passport;

    @Column(name = "Adress", length = 128, nullable = false)
    private String adress;

    @Column(name = "Telephone")
    private int telephone;

    public Employee() {
    }

    public Employee(String name, int passport, String adress, int telephone) {
        this.name = name;
        this.passport = passport;
        this.adress = adress;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassport() {
        return passport;
    }

    public void setPassport(int passport) {
        this.passport = passport;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
}
