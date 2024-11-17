package com.weatherApi.weatherApi.controller;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Weather")
public class WeatherDetails implements Serializable {
    private String temperature;
    private String feelsLikeTemparature;
    private String weatherDescrption;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    private String cityName;

    public WeatherDetails() {
    }

    public WeatherDetails(String temperature, String feelsLikeTemparature, String weatherDescrption,String cityName) {
        this.temperature = temperature;
        this.feelsLikeTemparature = feelsLikeTemparature;
        this.weatherDescrption = weatherDescrption;
        this.cityName = cityName;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getFeelsLikeTemparature() {
        return feelsLikeTemparature;
    }

    public void setFeelsLikeTemparature(String feelsLikeTemparature) {
        this.feelsLikeTemparature = feelsLikeTemparature;
    }

    public String getWeatherDescrption() {
        return weatherDescrption;
    }

    public void setWeatherDescrption(String weatherDescrption) {
        this.weatherDescrption = weatherDescrption;
    }
}
