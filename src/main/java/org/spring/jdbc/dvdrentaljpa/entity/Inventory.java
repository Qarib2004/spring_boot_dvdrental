package org.spring.jdbc.dvdrentaljpa.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inventory_id;
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    @Column(name = "last_update")
    private LocalDateTime last_update;

    public Inventory(int inventory_id, Film film, Store store, LocalDateTime last_update) {
        this.inventory_id = inventory_id;
        this.film = film;
        this.store = store;
        this.last_update = last_update;
    }

    public Inventory() {
    }

    public int getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }


    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventory_id=" + inventory_id +
                ", film_id=" + film +
                ", store_id=" + store +
                ", last_update=" + last_update +
                '}';
    }
}
