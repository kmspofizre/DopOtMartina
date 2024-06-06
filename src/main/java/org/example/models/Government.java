package org.example.models;


import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "government")
public class Government {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "government_name")
    private String name;

    @OneToMany(mappedBy = "government", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<City> cities;

    public List<City> getCities() {
        return cities;
    }

    public Government(){}

    public Government(String government_name){
        this.name = government_name;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

