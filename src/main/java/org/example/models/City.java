package org.example.models;


import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coordinate")
    private Coordinate coordinate;

    @Column(name = "creation_date")
    private LocalDate date;

    private int area;

    @Column(name = "city_population")
    private int cityPopulation;

    @Column(name = "meters_above_sea_level")
    private double metersAboveSeaLevel;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "climate")
    private Climate climate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "government")
    private Government government;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "standard_of_living")
    private StandardOfLiving standardOfLiving;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "governor")
    private Human governor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public City(){}

    public City(String name, Coordinate coordinate, int area,
                LocalDate date, int cityPopulation, double metersAboveSeaLevel, Climate climate,
                Government government, StandardOfLiving standardOfLiving, Human governor, User user){
        this.name = name;
        this.coordinate = coordinate;
        this.area = area;
        this.date = date;
        this.cityPopulation = cityPopulation;
        this.metersAboveSeaLevel = metersAboveSeaLevel;
        this.climate = climate;
        this.government = government;
        this.standardOfLiving = standardOfLiving;
        this.governor = governor;
        this.user = user;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Climate getClimate() {
        return climate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public double getMetersAboveSeaLevel() {
        return metersAboveSeaLevel;
    }

    public Government getGovernment() {
        return government;
    }

    public Human getGovernor() {
        return governor;
    }

    public int getArea() {
        return area;
    }

    public int getCityPopulation() {
        return cityPopulation;
    }

    public long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public StandardOfLiving getStandardOfLiving() {
        return standardOfLiving;
    }

    public void setCityPopulation(int cityPopulation) {
        this.cityPopulation = cityPopulation;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setClimate(Climate climate) {
        this.climate = climate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setGovernment(Government government) {
        this.government = government;
    }

    public void setGovernor(Human governor) {
        this.governor = governor;
    }

    public void setMetersAboveSeaLevel(double metersAboveSeaLevel) {
        this.metersAboveSeaLevel = metersAboveSeaLevel;
    }

    public void setStandardOfLiving(StandardOfLiving standardOfLiving) {
        this.standardOfLiving = standardOfLiving;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
