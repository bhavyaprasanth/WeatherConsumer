package com.weatherconsumer.SpringBootWeatherConsumer.service;

import org.springframework.http.ResponseEntity;

import com.weatherconsumer.SpringBootWeatherConsumer.Entity.User;
import com.weatherconsumer.SpringBootWeatherConsumer.responseDO.WeatherResponse;

public interface WeatherConsumerService {

	public User registerUser(User user);
	
	public ResponseEntity<WeatherResponse> getWeatherByCityName(String cityName);
	
	public ResponseEntity<WeatherResponse> getWeatherByCoordinates(String latitude, String longitude);
}
