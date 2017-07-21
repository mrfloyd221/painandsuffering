package com.painandsuffering.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;

/**
 * Created by mrflo on 18.06.2017.
 */

@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Order")
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="order_id")
    @Getter @Setter Integer id;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    @Getter @Setter User user;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="product_id")
    @Getter @Setter
    Product product;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
      @Getter @Setter OrderStatus status;



}

