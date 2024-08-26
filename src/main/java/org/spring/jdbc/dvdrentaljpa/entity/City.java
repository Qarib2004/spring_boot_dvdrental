package org.spring.jdbc.dvdrentaljpa.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int city_id;
    @Column(name = "city")
    private String city;
    @ManyToOne
    @JoinColumn(name = "country_id",nullable = false)
    private Country country;
    @Column(name = "last_update",nullable = false,updatable = true)
    private LocalDateTime last_update;

    public City(int city_id, String city, Country country, LocalDateTime last_update) {
        this.city_id = city_id;
        this.city = city;
        this.country = country;
        this.last_update = last_update;
    }

    public City() {
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity() {
        return city;
    }

    public City setCity(String city) {
        this.city = city;
        return null;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
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
        return "City{" +
                "city_id=" + city_id +
                ", city='" + city + '\'' +
                ", country=" + country +
                ", last_update=" + last_update +
                '}';
    }
}
