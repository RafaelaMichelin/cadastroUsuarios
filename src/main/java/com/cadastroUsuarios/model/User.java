package com.cadastroUsuarios.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="user_tbl")

public class User {
    @Id 
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name="id_user")
    private Long id;
     
    @Column(name="name_user")
    private String name;

    @Column(name= "date_user")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate date;

     @Column(name="email_user")
    private String email;

}
