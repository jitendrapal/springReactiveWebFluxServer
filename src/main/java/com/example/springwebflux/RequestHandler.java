package com.example.springwebflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class RequestHandler {
	@Autowired
    private DataMeargeService weatherService;
     public Mono<ServerResponse> 
            streamWeather(ServerRequest    request) {
    	 
    	 weatherService.streamWeather();
        return ServerResponse.ok()
               .contentType(MediaType.TEXT_EVENT_STREAM)
               .body(weatherService
               .streamWeather(),EventCombiner.class);
}

}
