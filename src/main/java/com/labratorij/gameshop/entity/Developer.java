package com.labratorij.gameshop.entity;

import org.springframework.context.annotation.Primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "developer", schema = "gameshop_eng")
public class Developer {

    @Column(name = "Developer", length = 64, nullable = false, unique = true)
    private String developer;

    @Column(name = "Adress", length = 128, nullable = false)
    private String adress;

    @Column(name = "Telephone", length = 64, nullable = false, unique = true)
    private String telephone;

    @Column(name = "Email", length = 64, nullable = false, unique = true)
    private String email;

    public Developer(String developer, String adress, String telephone, String email) {
        this.developer = developer;
        this.adress = adress;
        this.telephone = telephone;
        this.email = email;
    }

    public Developer() {
    }

    public String getDeveloper() {

        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Developer developer1 = (Developer) o;

        if (!developer.equals(developer1.developer)) return false;
        if (!adress.equals(developer1.adress)) return false;
        if (!telephone.equals(developer1.telephone)) return false;
        return email.equals(developer1.email);
    }

    @Override
    public int hashCode() {
        int result = developer.hashCode();
        result = 31 * result + adress.hashCode();
        result = 31 * result + telephone.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }
}
