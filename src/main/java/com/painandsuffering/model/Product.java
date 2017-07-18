package com.painandsuffering.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mrflo on 26.05.2017.
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Product")
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="product_id")
    @Getter @Setter private Integer id;
    @Column(name="product_name")
    @Getter @Setter private String name;
    @Column(name="price")
    @Getter @Setter private int price;



}
