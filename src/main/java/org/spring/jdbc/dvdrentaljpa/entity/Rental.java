package org.spring.jdbc.dvdrentaljpa.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "rental")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rental_id;
    @Column(name = "rental_date")
    private LocalDateTime rental_date;
    @ManyToOne
    @JoinColumn(name = "inventory_id",nullable = true)
    private Inventory inventory;
    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = true)
    private Customer customer;
    @Column(name = "return_date",nullable = false)
    private LocalDateTime return_date;
    @ManyToOne
    @JoinColumn(name = "staff_id",nullable = true)
    private Staff staff;
    @Column(name = "last_update")
    private LocalDateTime last_update;

    public Rental(int rental_id, LocalDateTime rental_date, Inventory inventory, Customer customer, LocalDateTime return_date, Staff staff, LocalDateTime last_update) {
        this.rental_id = rental_id;
        this.rental_date = rental_date;
        this.inventory = inventory;
        this.customer = customer;
        this.return_date = return_date;
        this.staff = staff;
        this.last_update = last_update;
    }

    public Rental() {
    }

    public int getRental_id() {
        return rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }

    public LocalDateTime getRental_date() {
        return rental_date;
    }

    public void setRental_date(LocalDateTime rental_date) {
        this.rental_date = rental_date;
    }

//    public int getInventory_id() {
//        return inventory_id;
//    }
//
//    public void setInventory_id(int inventory_id) {
//        this.inventory_id = inventory_id;
//    }
//
//    public int getCustomer_id() {
//        return customer_id;
//    }
//
//    public void setCustomer_id(int customer_id) {
//        this.customer_id = customer_id;
//    }

    public LocalDateTime getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDateTime return_date) {
        this.return_date = return_date;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    //    public int getStaff_id() {
//        return staff_id;
//    }
//
//    public void setStaff_id(int staff_id) {
//        this.staff_id = staff_id;
//    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rental_id=" + rental_id +
                ", rental_date=" + rental_date +
                ", inventory_id=" + inventory +
                ", customer_id=" + customer +
                ", return_date=" + return_date +
                ", staff_id=" + staff +
                ", last_update=" + last_update +
                '}';
    }
}
