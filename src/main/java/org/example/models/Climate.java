package org.example.models;


import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "climate")
public class Climate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "climate_name")
    private String name;

    @OneToMany(mappedBy = "climate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<City> cities;

    public Climate(){
    }
    public Climate(String climate_name){
        this.name = climate_name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

}

