package com.techbeat.qv.database.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Max Guenes on 04/12/2016.
 */
@Entity(name = "user")
public class UserEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name = "register_date", nullable = false)
    private Date registerDate;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @PrePersist
    protected void onCreate() {
        registerDate = new Date();
    }
}
