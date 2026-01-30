package com.cadastroUsuarios.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity 
@Table(name="user_tbl")

public class User {
    @Id 
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name="id_user")
    private Long id;
     
    @NotBlank(message = "**Nome obrigatório**")
    @Column(name="name_user")
    private String name;

    @NotNull(message = "**Data de nascimento obrigatória**")
    @Column(name= "date_user")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate date;
    

    @NotBlank(message = "**Email obrigatório**")
    @Email(message = "Email inválido")
    @Column(name="email_user")
    private String email;


    //Constructor 

    public User(){}

    public User(Long id, String name, LocalDate date, String email){
        this.id = id;
        this.name = name;
        this.date = date;
        this.email = email;
    }
    
    //GETTERS E SETTERS
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    } 

    public void setName(String name){
        this.name = name;
    }
 
    public LocalDate getDate(){
        return date;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

}
