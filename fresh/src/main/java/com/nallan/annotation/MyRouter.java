package com.nallan.annotation;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

@MessageEndpoint
public class MyRouter {

	private static final String ORDERS = "orders";

	@Router(inputChannel=ORDERS)
	public String doSomeRouting(Order message)
	{
		System.out.println("Router:: routing to drinks-split with message:"+message);
		if("CLEARANCE".equalsIgnoreCase(message.getType()))
		{
			return "clearanceChannel";
		}
		else
		{
			return "regularChannel";
		}
		
		
	}
}
