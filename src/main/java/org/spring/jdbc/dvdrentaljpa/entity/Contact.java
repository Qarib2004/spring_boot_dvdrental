package org.spring.jdbc.dvdrentaljpa.entity;



import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", tel='" + tel + '\'' +
                '}';
    }
}