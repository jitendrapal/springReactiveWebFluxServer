package com.example.springwebflux;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.google.gson.Gson;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DataMeargeService {

	@Autowired
	RestTemplate restTemplate;

	public Flux<EventCombiner> streamWeather() {
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
		Flux<EventCombiner> events = Flux.fromStream(Stream.generate(() -> apiCall()));
		return Flux.zip(events, interval, (key, value) -> key);
	}

	private EventCombiner apiCall() {

		String response1 = restTemplate.getForObject("http://localhost:2012/process", String.class);

		Gson gson = new Gson();
		MessageDetails staff = gson.fromJson(response1, MessageDetails.class);

		return new EventCombiner(staff, LocalDateTime.now());

	}
}
