package org.example.models;


import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "human")
public class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int age;

    @OneToMany(mappedBy = "governor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<City> cities;

    public Human(){}

    public Human(int age){
        this.age = age;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public int getId() {
        return id;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
