package org.spring.jdbc.dvdrentaljpa.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int store_id;
    @ManyToOne
    @JoinColumn(name = "manager_staff")
    private Staff manager_staff;
    @ManyToOne
    @JoinColumn(name = "address")
    private Address address;
    @Column(name = "last_update",nullable = false,updatable = true)
    private LocalDateTime last_update;

    public Store(int store_id, Staff manager_staff, Address address, LocalDateTime last_update) {
        this.store_id = store_id;
        this.manager_staff = manager_staff;
        this.address = address;
        this.last_update = last_update;
    }

    public Store() {
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

//    public int getManager_staff_id() {
//        return manager_staff_id;
//    }
//
//    public void setManager_staff_id(int manager_staff_id) {
//        this.manager_staff_id = manager_staff_id;
//    }
//
//    public int getAddress_id() {
//        return address_id;
//    }
//
//    public void setAddress_id(int address_id) {
//        this.address_id = address_id;
//    }


    public Staff getManager_staff() {
        return manager_staff;
    }

    public void setManager_staff(Staff manager_staff) {
        this.manager_staff = manager_staff;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "Store{" +
                "store_id=" + store_id +
             //   ", manager_staff_id=" + manager_staff +
              //  ", address_id=" + address +
                ", last_update=" + last_update +
                '}';
    }
}
