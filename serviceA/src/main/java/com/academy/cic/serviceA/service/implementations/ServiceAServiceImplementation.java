package com.academy.cic.serviceA.service.implementations;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.academy.cic.serviceA.dao.ServiceADAO;
import com.academy.cic.serviceA.service.ServiceAService;

@Service
public class ServiceAServiceImplementation implements ServiceAService {
	
	@Value("${serviceBUrl}")
	private String serviceBUrl;
	
	private Logger logger = Logger.getLogger(ServiceAServiceImplementation.class.getName());
	
	private final RestTemplate restTemplate;
	private final CircuitBreakerFactory circuitBreakerFactory;
	private final ServiceADAO serviceADAO;

	public ServiceAServiceImplementation (RestTemplate restTemplate, CircuitBreakerFactory circuitBreakerFactory, ServiceADAO serviceADAO) {
		this.restTemplate = restTemplate;
		this.circuitBreakerFactory = circuitBreakerFactory;
		this.serviceADAO = serviceADAO;
	}
	
	@Override
	public String getIBM() {
		return serviceADAO.getIBM();
	}

	@Override
	public String callB() {
	    return circuitBreakerFactory.create("breakerAtoB", "breakerAtoB").run(() -> restTemplate.getForEntity(serviceBUrl + "/getCloud", String.class).getBody(),
	      throwable -> getInfoFallbackAtoB(throwable));
	}
	
	public String getInfoFallbackAtoB(Throwable t) {
		logger.log(Level.SEVERE, "[Fallback (ServizioA)]: Errore durante la chiamata al servizio B: " + t.getMessage(), t);
		return "[Fallback] Cloud Academy Marzo 2023";
	}
	
}
