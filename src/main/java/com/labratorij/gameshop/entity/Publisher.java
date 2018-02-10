package com.labratorij.gameshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publisher", schema = "gameshop_eng")
public class Publisher {

    @Column(name = "Publisher", unique = true, length = 64)
    private String publisher;

    @Column(name = "Address", length = 128)
    private String address;

    @Column(name = "Telephone", unique = true)
    private int telephone;

    @Column(name = "Email", unique = true, length = 64)
    private String email;

    @OneToMany(mappedBy = "publisher")
    private List<Videogame> videogames = new ArrayList<Videogame>();

    public Publisher() {
    }

    public Publisher(String publisher, String address, int telephone, String email) {
        this.publisher = publisher;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
    }

    public Publisher(String publisher, String address, int telephone, String email, List<Videogame> videogames) {
        this.publisher = publisher;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.videogames = videogames;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Videogame> getVideogames() {
        return videogames;
    }

    public void setVideogames(List<Videogame> videogames) {
        this.videogames = videogames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher1 = (Publisher) o;

        if (telephone != publisher1.telephone) return false;
        if (!publisher.equals(publisher1.publisher)) return false;
        if (!address.equals(publisher1.address)) return false;
        if (!email.equals(publisher1.email)) return false;
        return videogames != null ? videogames.equals(publisher1.videogames) : publisher1.videogames == null;
    }

    @Override
    public int hashCode() {
        int result = publisher.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + telephone;
        result = 31 * result + email.hashCode();
        result = 31 * result + (videogames != null ? videogames.hashCode() : 0);
        return result;
    }
}
