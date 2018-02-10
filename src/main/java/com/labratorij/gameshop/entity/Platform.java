package com.labratorij.gameshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "platform", schema = "gameshop_eng")
public class Platform {

    @Column(name = "Platform", unique = true, length = 64)
    private String platform;

    @Column(name = "Producer", length = 64)
    private String producer;

    @Column(name = "Relevance")
    private int relevance;

    @ManyToMany(mappedBy = "platforms")
    private List<Videogame> videogames = new ArrayList<Videogame>();

    public Platform() {
    }

    public Platform(String platform, String producer, int relevance) {
        this.platform = platform;
        this.producer = producer;
        this.relevance = relevance;
    }

    public Platform(String platform, String producer, int relevance, List<Videogame> videogames) {
        this.platform = platform;
        this.producer = producer;
        this.relevance = relevance;
        this.videogames = videogames;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getRelevance() {
        return relevance;
    }

    public void setRelevance(int relevance) {
        this.relevance = relevance;
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

        Platform platform1 = (Platform) o;

        if (relevance != platform1.relevance) return false;
        if (!platform.equals(platform1.platform)) return false;
        if (!producer.equals(platform1.producer)) return false;
        return videogames != null ? videogames.equals(platform1.videogames) : platform1.videogames == null;
    }

    @Override
    public int hashCode() {
        int result = platform.hashCode();
        result = 31 * result + producer.hashCode();
        result = 31 * result + relevance;
        result = 31 * result + (videogames != null ? videogames.hashCode() : 0);
        return result;
    }
}
