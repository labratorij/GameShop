package com.labratorij.gameshop.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "videogame", schema = "gameshop_eng")
public class Videogame {

    @Column(name = "Videogame", unique = true, length = 64)
    private String videogame;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Developer")
    private Developer developer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Publisher")
    private Publisher publisher;

    @Column(name = "Genre", length = 64)
    private String genre;

    @Column(name = "Age rating")
    private int ageRating;

    @Column(name = "Date")
    private Date date;

    @Column(name = "Cost of purchase")
    private float costOfPurchase;

    @Column(name = "Price")
    private float price;

    @Column(name = "Quantity")
    private int quantity;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "platforms videogames", joinColumns = @JoinColumn(name = "Videogame"),inverseJoinColumns = @JoinColumn(name = "Platform"))
    private List<Platform> platforms = new ArrayList<Platform>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "orders videogames", joinColumns = @JoinColumn(name = "Game"), inverseJoinColumns = @JoinColumn(name = "Order"))
    private List<Order> orderList = new ArrayList<Order>();

    public Videogame(String videogame, Developer developer, Publisher publisher, String genre, int ageRating, Date date, float costOfPurchase, float price, int quantity) {
        this.videogame = videogame;
        this.developer = developer;
        this.publisher = publisher;
        this.genre = genre;
        this.ageRating = ageRating;
        this.date = date;
        this.costOfPurchase = costOfPurchase;
        this.price = price;
        this.quantity = quantity;
    }

    public Videogame(String videogame, Developer developer, Publisher publisher, String genre, int ageRating, Date date, float costOfPurchase, float price, int quantity, List<Platform> platforms) {
        this.videogame = videogame;
        this.developer = developer;
        this.publisher = publisher;
        this.genre = genre;
        this.ageRating = ageRating;
        this.date = date;
        this.costOfPurchase = costOfPurchase;
        this.price = price;
        this.quantity = quantity;
        this.platforms = platforms;
    }

    public Videogame(String videogame, Developer developer, Publisher publisher, String genre, int ageRating, Date date, float costOfPurchase, float price, int quantity, List<Platform> platforms, List<Order> orderList) {
        this.videogame = videogame;
        this.developer = developer;
        this.publisher = publisher;
        this.genre = genre;
        this.ageRating = ageRating;
        this.date = date;
        this.costOfPurchase = costOfPurchase;
        this.price = price;
        this.quantity = quantity;
        this.platforms = platforms;
        this.orderList = orderList;
    }

    public Videogame() {
    }

    public String getVideogame() {
        return videogame;
    }

    public void setVideogame(String videogame) {
        this.videogame = videogame;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getCostOfPurchase() {
        return costOfPurchase;
    }

    public void setCostOfPurchase(float costOfPurchase) {
        this.costOfPurchase = costOfPurchase;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Videogame videogame1 = (Videogame) o;

        if (ageRating != videogame1.ageRating) return false;
        if (Float.compare(videogame1.costOfPurchase, costOfPurchase) != 0) return false;
        if (Float.compare(videogame1.price, price) != 0) return false;
        if (quantity != videogame1.quantity) return false;
        if (!videogame.equals(videogame1.videogame)) return false;
        if (!developer.equals(videogame1.developer)) return false;
        if (!publisher.equals(videogame1.publisher)) return false;
        if (!genre.equals(videogame1.genre)) return false;
        if (!date.equals(videogame1.date)) return false;
        if (platforms != null ? !platforms.equals(videogame1.platforms) : videogame1.platforms != null) return false;
        return orderList != null ? orderList.equals(videogame1.orderList) : videogame1.orderList == null;
    }

    @Override
    public int hashCode() {
        int result = videogame.hashCode();
        result = 31 * result + developer.hashCode();
        result = 31 * result + publisher.hashCode();
        result = 31 * result + genre.hashCode();
        result = 31 * result + ageRating;
        result = 31 * result + date.hashCode();
        result = 31 * result + (costOfPurchase != +0.0f ? Float.floatToIntBits(costOfPurchase) : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + quantity;
        result = 31 * result + (platforms != null ? platforms.hashCode() : 0);
        result = 31 * result + (orderList != null ? orderList.hashCode() : 0);
        return result;
    }
}
