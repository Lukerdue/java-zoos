package com.lambdaschool.zoo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="zooanimals")
@IdClass(ZooAnimalsId.class)
public class ZooAnimals implements Serializable {
    @Id
    @OneToMany
    @JoinColumn(name="animalid")
    @JsonIgnoreProperties(value = "zoos", allowSetters = true)
    private Animal animal;

    @Id
    @OneToMany
    @JoinColumn(name="zooid")
    @JsonIgnoreProperties(value="animals", allowSetters = true)
    private Zoo zoo;

    public ZooAnimals() {
    }

    public ZooAnimals(Animal animal, Zoo zoo) {
        this.animal = animal;
        this.zoo = zoo;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ZooAnimals that = (ZooAnimals) o;
        return ((this.animal == null) ? 0 : this.animal.getAnimalid()) ==
                ((that.animal ==null)?0:that.animal.getAnimalid()) &&
                ((this.zoo == null) ? 0 : this.zoo.getZooid()) ==
                        ((that.zoo == null)?0:that.zoo.getZooid());
    }

    @Override
    public int hashCode() {
        return 16;
    }
}

