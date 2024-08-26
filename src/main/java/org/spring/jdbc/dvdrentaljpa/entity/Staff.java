package org.spring.jdbc.dvdrentaljpa.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Arrays;
@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staff_id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @ManyToOne
    @JoinColumn(name = "address_id",nullable = true)
    private Address address;
    @Column(name = "email")
    private String email;
    @ManyToOne
    @JoinColumn(name = "store_id",nullable = true)
    private Store store;
    @Column(name = "active")
    private boolean active;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "last_update")
    private LocalDateTime last_update;
    @Column(name = "picture",nullable = true)
    private byte[] picture;

    public Staff(int staff_id, String first_name, String last_name, Address address, String email, Store store, boolean active, String username, String password, LocalDateTime last_update, byte[] picture) {
        this.staff_id = staff_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.email = email;
        this.store = store;
        this.active = active;
        this.username = username;
        this.password = password;
        this.last_update = last_update;
        this.picture = picture;
    }

    public Staff() {
    }


    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

//    public int getAddress_id() {
//        return address_id;
//    }
//
//    public void setAddress_id(int address_id) {
//        this.address_id = address_id;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public int getStore_id() {
//        return store_id;
//    }
//
//    public void setStore_id(int store_id) {
//        this.store_id = store_id;
//    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }


    @Override
    public String toString() {
        return "Staff{" +
                "staff_id=" + staff_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
               // ", address_id=" + address +
                ", email='" + email + '\'' +
               // ", store_id=" + store +
                ", active=" + active +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", last_update=" + last_update +
                ", picture=" + Arrays.toString(picture) +
                '}';
    }
}
