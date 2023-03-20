package com.academy.cic.serviceB.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academy.cic.serviceB.service.implementations.ServiceBServiceImplementation;

@RestController
@RequestMapping(value="serviceB")
public class ServiceBController {
	
	private String hostname = System.getenv("HOSTNAME");
	private final ServiceBServiceImplementation serviceBServiceImplementation;

	public ServiceBController(ServiceBServiceImplementation serviceBServiceImplementation) {
		this.serviceBServiceImplementation = serviceBServiceImplementation;
	}
	
	@GetMapping(value="/getCloud", produces = "text/plain")
	public String serviceB() {
		
		if (hostname == null) {
			hostname = "unknown";
		}
		
		return serviceBServiceImplementation.getCloud() + " (" + hostname + ") " + serviceBServiceImplementation.callC();	
	}

}
