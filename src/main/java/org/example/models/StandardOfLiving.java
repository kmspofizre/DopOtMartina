package org.example.models;


import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "standard_of_living")
public class StandardOfLiving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "standard_of_living_name")
    private String name;

    @OneToMany(mappedBy = "standardOfLiving", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<City> cities;

    public StandardOfLiving(){}

    public StandardOfLiving(String standard_of_living_name){
        this.name = standard_of_living_name;
    }

    public List<City> getCities() {
        return cities;
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

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
