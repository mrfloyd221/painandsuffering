package com.painandsuffering.model;

/**
 * Created by mrflo on 26.05.2017.
 */
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userId")
    @Getter @Setter private Integer id;
    @Getter @Setter private String name;
    @OneToMany
    @Getter @Setter private List<Order> orders;
}
