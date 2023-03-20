package com.academy.cic.gatewayapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApiApplication {
	
	@Value("${gatewayFallback}")
	private String gatewayFallback;

	public static void main(String[] args) {
		SpringApplication.run(GatewayApiApplication.class, args);
	}
	
	/* Rotta stabilita attraverso il codice (compresa di filtro circuitbreaker e forward per la fallback
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		
		return builder.routes()
				.route("serviceA_route", r -> r
						.path("/serviceA/**")
						.filters(f -> f.circuitBreaker(config -> config
								.setName("breakerGatewayToA")
								.setFallbackUri(gatewayFallback)
								))
						.uri("lb://serviceA/"))
				.build();

	}
	*/
}
