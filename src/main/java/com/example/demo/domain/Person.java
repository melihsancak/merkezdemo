package com.example.demo.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="person")
public class Person {

    @GeneratedValue
    @Id
    private long id;

    @Column(name="first_name" , nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name="e_mail_address",nullable = false)
    private String mail;

    @Column(name="createdAt" )
    private Timestamp createdAt;
}
