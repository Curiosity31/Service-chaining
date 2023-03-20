package com.academy.cic.serviceD.service.implementations;

import org.springframework.stereotype.Service;
import com.academy.cic.serviceD.service.ServiceDService;

@Service
public class ServiceDServiceImplementation implements ServiceDService {

	@Override
	public String getDate() {
		return "Marzo 2023";
	}

}
