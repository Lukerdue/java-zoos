package com.lambdaschool.zoo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="animals")
public class Animal extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animalid;
    private String animaltype;

    @OneToMany( mappedBy = "animal", cascade= CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value="animal", allowSetters=true)
    private List<ZooAnimals> zoos = new ArrayList<>();


    public Animal() {
    }

    public Animal(long animalid, String animaltype, List<ZooAnimals> zoos) {
        this.animalid = animalid;
        this.animaltype = animaltype;
        this.zoos = zoos;
    }


    public long getAnimalid() {
        return animalid;
    }

    public void setAnimalid(long animalid) {
        this.animalid = animalid;
    }

    public String getAnimaltype() {
        return animaltype;
    }

    public void setAnimaltype(String animaltype) {
        this.animaltype = animaltype;
    }

    public List<ZooAnimals> getZoos() {
        return zoos;
    }

    public void setZoos(List<ZooAnimals> zoos) {
        this.zoos = zoos;
    }
}