package com.samples.anno;

import org.springframework.integration.annotation.Gateway;

public interface OrderProcessingGateway {
	
	@Gateway(requestChannel="orders")
	void placeOrder(Order order);
	
}
