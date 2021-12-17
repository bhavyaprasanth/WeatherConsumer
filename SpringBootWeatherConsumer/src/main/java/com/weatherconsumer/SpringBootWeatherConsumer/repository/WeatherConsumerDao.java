package com.weatherconsumer.SpringBootWeatherConsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weatherconsumer.SpringBootWeatherConsumer.Entity.User;

public interface WeatherConsumerDao extends JpaRepository<User, Integer>{
	
}
