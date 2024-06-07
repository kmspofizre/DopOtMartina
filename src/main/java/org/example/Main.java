package org.example;


import org.example.models.*;
import org.example.services.CityService;
import org.example.services.UserService;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        CityService cityService = new CityService();
        System.out.println(cityService.findCity(2));
        List<City> cityList = cityService.zpr("TragicCity");
        for (City city : cityList){
            System.out.println(city);
        }
        List<String> citiesList = new ArrayList<>();
        citiesList.add("Magic City");
        citiesList.add("Tragic City");
        citiesList.add("One More City");
        citiesList.add("City of Sins");
        citiesList.add("CitCity");
        citiesList.add("Night City");
        Random randomizer = new Random();

        for (int i = 0; i < 10000; i++){
            String cityName = citiesList.get(randomizer.nextInt(citiesList.size()));
            Climate climate = cityService.findClimateById(ThreadLocalRandom.current().nextInt(1, 4 + 1));
            Government government = cityService.findGovernmentById(ThreadLocalRandom.current().nextInt(1, 3 + 1));
            StandardOfLiving standardOfLiving = cityService.findStandardOfLivingById(ThreadLocalRandom.current().nextInt(1, 3 + 1));
            Coordinate coordinate = cityService.findCoordinatesById(ThreadLocalRandom.current().nextInt(1, 20 + 1));
            User user = cityService.findUserById(ThreadLocalRandom.current().nextInt(6, 12 + 1));
            Human governor = cityService.findHumanById(ThreadLocalRandom.current().nextInt(1, 11 + 1));
            City city = new City(cityName, 35, LocalDate.now(),
                            33, 54.5);


            city.setClimate(climate);
            city.setCoordinate(coordinate);
            city.setGovernment(government);
            city.setGovernor(governor);
            city.setStandardOfLiving(standardOfLiving);
            city.setUser(user);
            //cityService.updateCity(city);
            cityService.saveCity(city);
        }



        //

        //
        //UserService userService = new UserService();
        //System.out.println(userService.findAutoById(2));
        //User user = new User("Masha",26);
        //userService.saveUser(user);
        //Auto ferrari = new Auto("Ferrari", "red");
        //user.addAuto(ferrari);
        //Auto ford = new Auto("Ford", "black");
        //ford.setUser(user);
        //user.addAuto(ford);
        //userService.updateUser(user);
        //user.setName("Sasha");
        //userService.updateUser(user);
        //userService.deleteUser(user);
    }
}