package com.samples.load;

import com.samples.anno.Order;
import com.samples.anno.OrderProcessingGateway;

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
