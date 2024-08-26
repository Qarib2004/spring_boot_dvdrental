package org.spring.jdbc.dvdrentaljpa.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payment_id;
    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = true)
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "staff_id",nullable = true)
    private Staff staff;
    @ManyToOne
    @JoinColumn(name = "rental_id",nullable = true)
    private Rental rental;
    @Column(name = "amount")
    private double amount;
    @Column(name = "payment_date",nullable = false,updatable = true)
    private LocalDateTime payment_date;

    public Payment(int payment_id, Customer customer, Staff staff, Rental rental, double amount, LocalDateTime payment_date) {
        this.payment_id = payment_id;
        this.customer = customer;
        this.staff = staff;
        this.rental = rental;
        this.amount = amount;
        this.payment_date = payment_date;
    }

    public Payment() {
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
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

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(LocalDateTime payment_date) {
        this.payment_date = payment_date;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payment_id=" + payment_id +
                ", customer=" + customer +
                ", staff=" + staff +
                ", rental=" + rental +
                ", amount=" + amount +
                ", payment_date=" + payment_date +
                '}';
    }
}
