package com.example.springwebflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Configuration
public class RequestRouter {
	
	@Bean
    RouterFunction<?> routes(RequestHandler requestHandler) {
        return RouterFunctions
               .route(RequestPredicates
               .GET("/datastream"), 
               requestHandler::streamWeather);
     }
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
