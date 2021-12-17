package com.weatherconsumer.SpringBootWeatherConsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.weatherconsumer.SpringBootWeatherConsumer.Entity.User;
import com.weatherconsumer.SpringBootWeatherConsumer.responseDO.WeatherResponse;
import com.weatherconsumer.SpringBootWeatherConsumer.service.WeatherConsumerService;

/**
 * @author Bhavya Mohan
 *
 */
@RestController
public class WeatherConsumerController {

    @Autowired
	private WeatherConsumerService weatherConsumerService;
	/**
	 * @param user
	 * @return
	 */
	@RequestMapping(value= {"/register"}, method= {RequestMethod.POST}) 
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		User savedUser = weatherConsumerService.registerUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.OK);
	}
	
	/**
	 * @return
	 */
	@RequestMapping(value= {"/getByCityName"}, method= {RequestMethod.GET}) 
	public ResponseEntity<WeatherResponse> getWeatherByCityName() {
		ResponseEntity<WeatherResponse> weatherResponse = weatherConsumerService.getWeatherByCityName("kerala,IND");
		return weatherResponse;
	}
	/**
	 * @return
	 */
	@RequestMapping(value= {"/getByCoordinates"}, method= {RequestMethod.GET}) 
	public ResponseEntity<WeatherResponse> getWeatherByCoordinates() {
		ResponseEntity<WeatherResponse> weatherResponse = weatherConsumerService.getWeatherByCoordinates("10.8505° N", "76.2711° E");
		return weatherResponse;
	}
	}

