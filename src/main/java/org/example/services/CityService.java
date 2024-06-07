package org.example.services;

import org.example.dao.CityDao;
import org.example.models.*;

import java.util.List;

public class CityService {
    private CityDao cityDao = new CityDao();

    public CityService(){}

    public City findCity(long id){
        return cityDao.findById(id);
    }

    public void saveCity(City city){
        cityDao.save(city);
    }

    public void deleteCity(City city) {
        cityDao.delete(city);
    }

    public void updateCity(City city) {
        cityDao.update(city);
    }

    public List<City> findAllCities(){
        return cityDao.findAll();
    }

    public Human findHumanById(int id){
        return cityDao.findHumanById(id);
    }

    public Climate findClimateById(int id) {
        return cityDao.findClimateById(id);
    }

    public Coordinate findCoordinatesById(int id) {
        return this.cityDao.findCoordinatesById(id);
    }

    public Government findGovernmentById(int id) {
        return cityDao.findGovernmentById(id);
    }

    public StandardOfLiving findStandardOfLivingById(int id) {
        return cityDao.findStandardOfLivingById(id);
    }

    public User findUserById(int id){
        return cityDao.findUserById(id);
    }
    public List<City> zpr(String name){
        return cityDao.zpr(name);
    }
}
