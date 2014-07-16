package com.nallan.load;

import com.nallan.annotation.Order;
import com.nallan.annotation.OrderProcessingGateway;

public class OrderProcessingJob implements Runnable {

	private OrderProcessingGateway orderProcessingGateway;
	private Order order;

	public OrderProcessingJob(OrderProcessingGateway orderProcessingGateway, Order order) {
		super();
		this.orderProcessingGateway = orderProcessingGateway;
		this.order = order;
	}

	public void run() {
		orderProcessingGateway.placeOrder(order);
	}

}
