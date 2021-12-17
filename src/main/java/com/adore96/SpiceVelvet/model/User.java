package com.adore96.SpiceVelvet.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author kasun_k ON 12/16/21
 * @project SpiceVelvet
 */

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private String fname;
    private String lname;
    private String username;
    private String password;
    private int telephone;
}
