package com.academy.cic.serviceA.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academy.cic.serviceA.service.implementations.ServiceAServiceImplementation;

@RestController
@RequestMapping(value="serviceA")
public class ServiceAController {

    private String hostname = System.getenv("HOSTNAME");
    private final ServiceAServiceImplementation serviceAServiceImplementation;

    public ServiceAController(ServiceAServiceImplementation serviceAServiceImplementation) {
        this.serviceAServiceImplementation = serviceAServiceImplementation;
    }

    @GetMapping(value="/getIBM", produces="text/plain")
    public String serviceA() {

        if (hostname == null) {
            hostname = "unknown";
        }

        //return serviceAServiceImplementation.getIBM() + " (" + hostname + ") " + serviceAServiceImplementation.callB();
        return serviceAServiceImplementation.getIBM() + " (" + hostname + ") " + serviceAServiceImplementation.callB();

    }

}