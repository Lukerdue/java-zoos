package com.lambdaschool.zoo.models;

import javax.persistence.*;

public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long phoneid;
    private String phonetype;
    private String phonenumber;

    @OneToMany
    @JoinColumn(name="phones")
    private Zoo zoo;
}
