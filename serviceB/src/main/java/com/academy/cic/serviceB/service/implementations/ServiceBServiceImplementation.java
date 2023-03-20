package com.academy.cic.serviceB.service.implementations;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.academy.cic.serviceB.service.ServiceBService;

@Service
public class ServiceBServiceImplementation implements ServiceBService {

	@Value("${serviceCUrl}")
	private String serviceCUrl;
	
	private Logger logger = Logger.getLogger(ServiceBServiceImplementation.class.getName());
	private final RestTemplate restTemplate;
	private final CircuitBreakerFactory circuitBreakerFactory;

	public ServiceBServiceImplementation (RestTemplate restTemplate, CircuitBreakerFactory circuitBreakerFactory) {
		this.restTemplate = restTemplate;
		this.circuitBreakerFactory = circuitBreakerFactory;
	}

	@Override
	public String getCloud() {
		return "Cloud";
	}
	
	@Override
	public String callC() {
	    return circuitBreakerFactory.create("breakerBtoC", "breakerBtoC").run(() -> restTemplate.getForEntity(serviceCUrl + "/getAcademy", String.class).getBody(),
	      throwable -> getInfoFallbackBtoC(throwable));
	}
	
	public String getInfoFallbackBtoC(Throwable t) {
		logger.log(Level.SEVERE, "[Fallback (ServizioB): Errore durante la chiamata al servizio C: " + t.getMessage(), t);
		return "[Fallback] Academy Marzo 2023";
	}

}
