package com.weatherApi.weatherApi.controller;


import com.weatherApi.weatherApi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ControllerApplication {

    @Autowired
    public WeatherService weatherService;

    Logger logger = Logger.getLogger(ControllerApplication.class.toString());

    @GetMapping("/weather/{city}")
    @Cacheable(key = "#city",value = "Weather")
    public WeatherDetails getWeatherDetails(@PathVariable String city){
        logger.info("The city is "+ city);

        return weatherService.getWeatherData(city);
    }
}
