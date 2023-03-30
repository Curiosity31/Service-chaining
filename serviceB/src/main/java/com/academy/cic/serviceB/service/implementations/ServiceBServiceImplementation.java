package com.academy.cic.serviceB.service.implementations;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.academy.cic.serviceB.dao.ServiceBDAO;
import com.academy.cic.serviceB.service.ServiceBService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ServiceBServiceImplementation implements ServiceBService {

	@Value("${serviceCUrl}")
	private String serviceCUrl;
	
	private Logger logger = Logger.getLogger(ServiceBServiceImplementation.class.getName());
	private final RestTemplate restTemplate;
	//private final CircuitBreakerFactory circuitBreakerFactory;
	private final ServiceBDAO serviceBDAO;

	public ServiceBServiceImplementation (RestTemplate restTemplate, ServiceBDAO serviceBDAO) {
		this.restTemplate = restTemplate;
		//this.circuitBreakerFactory = circuitBreakerFactory;
		this.serviceBDAO = serviceBDAO;
	}

	@Override
	public String getCloud() {
		return serviceBDAO.getCloud();
	}
	
	/*
	@Override
	public String callC() {
	    return circuitBreakerFactory.create("breakerBtoC", "breakerBtoC").run(() -> restTemplate.getForEntity(serviceCUrl + "/getAcademy", String.class).getBody(),
	      throwable -> getInfoFallbackBtoC(throwable));
	}
	*/
	
	@Override
	@CircuitBreaker(name="breakerBtoC", fallbackMethod="getInfoFallbackBtoC")
	public String callC() {
	    return restTemplate.getForEntity(serviceCUrl + "/getAcademy", String.class).getBody();
	}
	
	public String getInfoFallbackBtoC(Throwable t) {
		logger.log(Level.SEVERE, "[Fallback (ServizioB): Errore durante la chiamata al servizio C: " + t.getMessage(), t);
		return "[Fallback] Academy Marzo 2023";
	}

}
