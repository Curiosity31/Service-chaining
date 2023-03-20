package com.academy.cic.gatewayapi.fallbackController;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

@RestController
@RequestMapping(value="fallback")
public class FallbackController {
	
	private Logger logger = Logger.getLogger(FallbackController.class.getName());
	
	@GetMapping(value="/gatewayfallback")
	public String gatewayFallbackMessage(ServerWebExchange exchange) {
	    Throwable throwable = exchange.getAttribute(ServerWebExchangeUtils.CIRCUITBREAKER_EXECUTION_EXCEPTION_ATTR);
		logger.log(Level.SEVERE, "[Fallback (gateway)]: Errore durante la chiamata al servizio A: " + throwable.getMessage(), throwable);
		return "[API Gateway Fallback] IBM Cloud Academy Marzo 2023";
	}}