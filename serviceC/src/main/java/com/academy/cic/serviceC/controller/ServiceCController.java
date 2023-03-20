package com.academy.cic.serviceC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academy.cic.serviceC.service.implementations.ServiceCServiceImplementation;

@RestController
@RequestMapping(value="serviceC")
public class ServiceCController {
	
	private String hostname = System.getenv("HOSTNAME");
	private final ServiceCServiceImplementation serviceCServiceImplementation;

	public ServiceCController(ServiceCServiceImplementation serviceCServiceImplementation) {
		this.serviceCServiceImplementation = serviceCServiceImplementation;
	}
	
	@GetMapping(value="/getAcademy", produces="text/plain")
	public String serviceC() {
		
		if (hostname == null) {
			hostname = "unknown";
		}
		
		return serviceCServiceImplementation.getAcademy() + " (" + hostname + ") " + serviceCServiceImplementation.callD();	
	}

}
