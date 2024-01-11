package com.intech.eventprocessor.pojo;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;



@NamedQuery(name = "User.findByEmail",query = "select u from User u where u.email=:email")
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "usuario")
    private String nombre;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "edad")
    private String edad;
    @Column(name = "dni")
    private String dni;
    @Column(name = "rol")
    private String rol;
    @Column(name = "password")
    private String password;
    @Column(name = "mail")
    private String mail;
    @Column(name = "id_Registro")
    private String id_Registro;




}
