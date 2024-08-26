package org.spring.jdbc.dvdrentaljpa.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private int country_id;
    @Column(name = "country",nullable = false)
    private String country;
    @Column(name = "last_update",nullable = false,updatable = true)
    private LocalDateTime last_update;

    public Country(int country_id, String country, LocalDateTime last_update) {
        this.country_id = country_id;
        this.country = country;
        this.last_update = last_update;
    }

    public Country() {
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "Country{" +
                "country_id=" + country_id +
                ", country='" + country + '\'' +
                ", last_update=" + last_update +
                '}';
    }
}
