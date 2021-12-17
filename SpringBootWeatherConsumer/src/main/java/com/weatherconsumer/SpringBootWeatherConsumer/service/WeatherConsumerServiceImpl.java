package com.weatherconsumer.SpringBootWeatherConsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.weatherconsumer.SpringBootWeatherConsumer.Entity.User;
import com.weatherconsumer.SpringBootWeatherConsumer.adapter.WeatherConsumerAdapter;
import com.weatherconsumer.SpringBootWeatherConsumer.repository.WeatherConsumerDao;
import com.weatherconsumer.SpringBootWeatherConsumer.responseDO.WeatherResponse;

@Service
public class WeatherConsumerServiceImpl implements WeatherConsumerService {
	
	@Autowired
	private WeatherConsumerDao weatherConsumerDao;
	
	@Autowired
	private WeatherConsumerAdapter weatherConsumerAdapter;
	

	@Override
	public User registerUser(User user) {
		User savedUser = weatherConsumerDao.save(user);
		return savedUser;
		
	}

	@Override
	public ResponseEntity<WeatherResponse> getWeatherByCityName(String cityName) {
	
		ResponseEntity<WeatherResponse> weatherResponse = weatherConsumerAdapter.getWeatherByCityName(cityName);
		return weatherResponse;
	}

	@Override
	public ResponseEntity<WeatherResponse> getWeatherByCoordinates(String latitude, String longitude) {
		
		ResponseEntity<WeatherResponse> weatherResponse = weatherConsumerAdapter.getWeatherByCoordinates(latitude, longitude);
		return weatherResponse;
	}

}
