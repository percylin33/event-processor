package com.intech.eventprocessor.pojo;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
@NamedQuery(name = "Product.findByEmail",query = "select u from Product u where u.nombre=:nombre")
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="product")
public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "nombre")
        private String nombre;

        @Column(name = "precio")
        private Float precio;

        @Column(name = "stock")
        private Integer stock;

        @Column(name = "id_Registro")
        private String id_Registro;


}
