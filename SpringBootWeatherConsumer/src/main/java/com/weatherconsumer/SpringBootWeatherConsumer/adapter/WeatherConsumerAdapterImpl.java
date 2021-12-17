package com.weatherconsumer.SpringBootWeatherConsumer.adapter;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.weatherconsumer.SpringBootWeatherConsumer.responseDO.WeatherResponse;

@Component
public class WeatherConsumerAdapterImpl implements WeatherConsumerAdapter {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private final String uri = "api.openweathermap.org/data/2.5/weather";
	private final String apiKey = "cd54b7fbdaf08c6e9677d93bfb7a35b2";

	@Override
	public  ResponseEntity<WeatherResponse> getWeatherByCityName(String cityName) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");

		UriComponents builder = UriComponentsBuilder.fromHttpUrl(uri)
		                        .queryParam("q",cityName)
		                        .queryParam("appid","cd54b7fbdaf08c6e9677d93bfb7a35b2")
		                        .build();

		    HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);

		    ResponseEntity<WeatherResponse> strResponse = restTemplate.exchange(builder.toUriString(),HttpMethod.GET, requestEntity,
		    		WeatherResponse.class);
		    return strResponse;
	}

	@Override
	public ResponseEntity<WeatherResponse> getWeatherByCoordinates(String latitude, String longitude) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");

		UriComponents builder = UriComponentsBuilder.fromHttpUrl(uri)
		                        .queryParam("lat",latitude)
		                        .queryParam("lon", longitude)
		                        .queryParam("appid",apiKey)
		                        .build();

		    HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);

		    ResponseEntity<WeatherResponse> strResponse = restTemplate.exchange(builder.toUriString(),HttpMethod.GET, requestEntity,
		    		WeatherResponse.class);
		    return strResponse;
	}
	
	

}
