package org.example.models;


import jakarta.persistence.*;


import java.util.List;


@Entity
@Table(name = "coordinates")
public class Coordinate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    float x;

    int y;

    @OneToMany(mappedBy = "coordinate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<City> cities;

    public Coordinate(){}

    public Coordinate(float x, int y){
        this.x = x;
        this.y = y;
    }

    public List<City> getCities() {
        return cities;
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

    public float getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


}
