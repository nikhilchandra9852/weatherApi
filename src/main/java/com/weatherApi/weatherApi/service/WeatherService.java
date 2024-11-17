package com.weatherApi.weatherApi.service;


import com.weatherApi.weatherApi.controller.WeatherDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class WeatherService {

    @Value("${weatherApiUrl}")
    public  String weatherUrl;
    @Value("${weatherApiKey}")
    public  String weatherApiKey;
    Logger logger = Logger.getLogger(WeatherService.class.toString());

    @Autowired
    public RestTemplate restTemplate;

    public WeatherDetails getWeatherData(String cityName){

        String url = weatherUrl+"?q="+cityName +"&appid=" + weatherApiKey +"&units=metric";
        HashMap dataFromAPi = restTemplate.getForEntity(url, HashMap.class).getBody();
        WeatherDetails weatherDetails = new WeatherDetails();
        weatherDetails.setCityName(cityName);
        if(dataFromAPi.keySet().contains("main")){
            HashMap data = (HashMap) dataFromAPi.get("main");
            weatherDetails.setTemperature(data.getOrDefault("temp","Temperature Not found").toString());
            weatherDetails.setFeelsLikeTemparature(data.getOrDefault("feels_like","Temperature Not Found").toString());
        }
       if(dataFromAPi.keySet().contains("weather")){
            List data = (List) dataFromAPi.get("weather");
            if(data.stream().findAny().isPresent()){
                Map weatherData = (Map) data.stream().findFirst().get();
                weatherDetails.setWeatherDescrption(weatherData.getOrDefault("description","Temperature Not Found").toString());
            }
        }
       logger.info(weatherDetails.toString());
        return weatherDetails;
    }
}
