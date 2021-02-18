package com.lambdaschool.zoo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooid;
    private String zooname;

    @OneToMany(mappedBy = "zoo")
    private List<Telephone> phones = new ArrayList<>();

    @OneToMany(mappedBy="zoo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value="zoos")
    private List<ZooAnimals> animals = new ArrayList<>();

    public Zoo() {
    }

    public Zoo(long zooid, String zooname, List<Telephone> phones, List<ZooAnimals> animals) {
        this.zooid = zooid;
        this.zooname = zooname;
        this.phones = phones;
        this.animals = animals;
    }

    public long getZooid() {
        return zooid;
    }

    public void setZooid(long zooid) {
        this.zooid = zooid;
    }

    public String getZooname() {
        return zooname;
    }

    public void setZooname(String zooname) {
        this.zooname = zooname;
    }

    public List<Telephone> getPhones() {
        return phones;
    }

    public void setPhones(List<Telephone> phones) {
        this.phones = phones;
    }

    public List<ZooAnimals> getAnimals() {
        return animals;
    }

    public void setAnimals(List<ZooAnimals> animals) {
        this.animals = animals;
    }
}
