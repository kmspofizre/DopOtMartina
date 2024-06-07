package org.example;


import org.example.models.*;
import org.example.services.CityService;
import org.example.services.UserService;

import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        CityService cityService = new CityService();
        System.out.println(cityService.findCity(2));
        List<City> cityList = cityService.zpr("TragicCity");
        for (City city : cityList){
            System.out.println(city);
        }
        //Coordinate coordinates = new Coordinate(23, 32);


        //Climate climate = cityService.findClimateById(2);
        //Government government = cityService.findGovernmentById(2);
        //StandardOfLiving standardOfLiving = cityService.findStandardOfLivingById(2);
        //Human governor = cityService.findHumanById(5);
        //User user = cityService.findUserById(9);
        //City city = new City("Name", coordinates, 35, LocalDate.now(),
        //        33, 54.5, climate, government, standardOfLiving, governor, user);

        //cityService.saveCity(city);
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