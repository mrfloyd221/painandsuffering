package com.painandsuffering.model;

/**
 * Created by mrflo on 26.05.2017.
 */
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "User")
@Table(name="users")
public class User{
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="user_id")
    @Getter @Setter private Integer id;
    @Column(name="username")
    @Getter @Setter private String name;
}
