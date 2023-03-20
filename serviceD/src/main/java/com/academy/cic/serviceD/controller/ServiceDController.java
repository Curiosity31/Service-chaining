package com.academy.cic.serviceD.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academy.cic.serviceD.service.implementations.ServiceDServiceImplementation;

@RestController
@RequestMapping(value="serviceD")
public class ServiceDController {
	
	private String hostname = System.getenv("HOSTNAME");
	private final ServiceDServiceImplementation serviceDServiceImplementation;

	public ServiceDController(ServiceDServiceImplementation serviceDServiceImplementation) {
		this.serviceDServiceImplementation = serviceDServiceImplementation;
	}
	
	@GetMapping(value="/getDate", produces="text/plain")
	public String getServiceD() {
		
		if (hostname == null) {
			hostname = "unknown";
		}
		
		return serviceDServiceImplementation.getDate() + " (" + hostname + ")";
	}

}
