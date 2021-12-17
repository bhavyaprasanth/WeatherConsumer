package com.weatherconsumer.SpringBootWeatherConsumer.adapter;

import org.springframework.http.ResponseEntity;

import com.weatherconsumer.SpringBootWeatherConsumer.responseDO.WeatherResponse;

public interface WeatherConsumerAdapter {
	
	public ResponseEntity<WeatherResponse> getWeatherByCityName(String cityName);
	
	public ResponseEntity<WeatherResponse> getWeatherByCoordinates(String latitude, String longitude);

}
