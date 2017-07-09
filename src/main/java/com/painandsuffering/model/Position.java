package com.painandsuffering.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mrflo on 26.05.2017.
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="positions")
public class Position{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="positionId")
    @Getter @Setter private int id;
    @Getter @Setter private String name;
    @Getter @Setter private int price;



}
