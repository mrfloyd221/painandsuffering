package com.painandsuffering.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

/**
 * Created by mrflo on 18.06.2017.
 */

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter int id;
    @OneToOne
    @JoinColumn(name="userId")
    @Getter @Setter User user;
    @ManyToOne
    @JoinColumn(name="positionId")
    @Getter @Setter Position position;
      @Getter @Setter boolean complete;



}
