package org.example.services;

import org.example.dao.CityDao;
import org.example.models.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CityService {
    private CityDao cityDao = new CityDao();

    public CityService() throws SQLException, IOException {}

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

    public void createIndex() throws SQLException {
        cityDao.createIndex();
    }

    // лайтовый селект, нужен был, чтобы проверить, как работает время
    public void goodSelection() throws SQLException {
        long time = System.currentTimeMillis();
        cityDao.goodSelection();
        System.out.println("goodSelection time: " + (System.currentTimeMillis() - time));
    }

    // следующий метод вызывает большой SELECT, если время превышает заданное,
    // то добавляются индексы и SELECT вызывается заново для проверки времени
    public void goodGoodSelection() throws SQLException {
        long time = System.currentTimeMillis();
        cityDao.goodGoodSelection();
        System.out.println("goodGoodSelection time: " + (System.currentTimeMillis() - time));
        if ((System.currentTimeMillis() - time) > 750) {
            createIndex();
            goodGoodSelection();
        }
    }
}
