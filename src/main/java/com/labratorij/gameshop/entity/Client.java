package com.labratorij.gameshop.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Number of card", schema = "gameshop_eng")
public class Client implements Serializable {

    @Id
    @GenericGenerator(name = "inc", strategy = "increment")
    @GeneratedValue(generator = "inc")
    @Column(name = "Number of card")
    private int id;

    @Column(name = "Name", length = 64)
    private String name;

    @Column(name = "Email", length = 64, unique = true)
    private String email;

    @Column(name = "Telephone", length = 64, unique = true)
    private String telephone;

    public Client() {
    }

    public Client(String name, String email, String telephone) {
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != client.id) return false;
        if (!name.equals(client.name)) return false;
        if (!email.equals(client.email)) return false;
        return telephone.equals(client.telephone);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + telephone.hashCode();
        return result;
    }
}
