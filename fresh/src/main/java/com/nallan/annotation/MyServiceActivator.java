package com.nallan.annotation;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;


@Component
public class MyServiceActivator {
	
	@ServiceActivator(inputChannel="ready")
	public void processMessage(String value)
	{	
		System.out.println("Service Activator:: is ready with the merchandise: "+value);
	}
	
}
