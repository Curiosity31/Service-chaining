package com.academy.cic.serviceC.service.implementations;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.academy.cic.serviceC.service.ServiceCService;

@Service
public class ServiceCServiceImplementation implements ServiceCService {

	
	@Value("${serviceDUrl}")
	private String serviceDUrl;
	
	private Logger logger = Logger.getLogger(ServiceCServiceImplementation.class.getName());
	private final RestTemplate restTemplate;
	private final CircuitBreakerFactory circuitBreakerFactory;

	public ServiceCServiceImplementation (RestTemplate restTemplate, CircuitBreakerFactory circuitBreakerFactory) {
		this.restTemplate = restTemplate;
		this.circuitBreakerFactory = circuitBreakerFactory;
	}

	@Override
	public String getAcademy() {
		return "Academy";
	}

	@Override
	public String callD() {
	    return circuitBreakerFactory.create("breakerCtoD", "breakerCtoD").run(() -> restTemplate.getForEntity(serviceDUrl + "/getDate", String.class).getBody(),
	      throwable -> getInfoFallbackCtoD(throwable));
	}
	
	public String getInfoFallbackCtoD(Throwable t) {
		logger.log(Level.SEVERE, "[Fallback (ServizioC)]: Errore durante la chiamata al servizio D: " + t.getMessage(), t);
		return "[Fallback] Marzo 2023";
	}

}
