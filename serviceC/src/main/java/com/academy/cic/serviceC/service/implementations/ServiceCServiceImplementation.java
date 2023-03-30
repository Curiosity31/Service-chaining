package com.academy.cic.serviceC.service.implementations;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.academy.cic.serviceC.dao.ServiceCDAO;
import com.academy.cic.serviceC.service.ServiceCService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ServiceCServiceImplementation implements ServiceCService {

	
	@Value("${serviceDUrl}")
	private String serviceDUrl;
	
	private Logger logger = Logger.getLogger(ServiceCServiceImplementation.class.getName());
	private final RestTemplate restTemplate;
	//private final CircuitBreakerFactory circuitBreakerFactory;
	private final ServiceCDAO serviceCDAO;

	public ServiceCServiceImplementation (RestTemplate restTemplate, ServiceCDAO serviceCDAO) {
		this.restTemplate = restTemplate;
		//this.circuitBreakerFactory = circuitBreakerFactory;
		this.serviceCDAO = serviceCDAO;
	}

	@Override
	public String getAcademy() {
		return serviceCDAO.getAcademy();
	}

	/*
	@Override
	public String callD() {
	    return circuitBreakerFactory.create("breakerCtoD", "breakerCtoD").run(() -> restTemplate.getForEntity(serviceDUrl + "/getDate", String.class).getBody(),
	      throwable -> getInfoFallbackCtoD(throwable));
	}*/
	
	@Override
	@CircuitBreaker(name="breakerCtoD", fallbackMethod="getInfoFallbackCtoD")
	public String callD() {
	    return restTemplate.getForEntity(serviceDUrl + "/getDate", String.class).getBody();
	}
	
	public String getInfoFallbackCtoD(Throwable t) {
		logger.log(Level.SEVERE, "[Fallback (ServizioC)]: Errore durante la chiamata al servizio D: " + t.getMessage(), t);
		return "[Fallback] Marzo 2023";
	}

}
