package com.samples.load;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.samples.anno.Item;
import com.samples.anno.Order;
import com.samples.anno.OrderProcessingGateway;

public class CafeDemo {

	private static final String SPRING_CONFIG = "\\META-INF\\spring\\integration\\*-context.xml";
	private static AbstractApplicationContext context = null;

	public static void main(String[] a) {
		try {

			context = new ClassPathXmlApplicationContext(SPRING_CONFIG);
			context.start();
			OrderProcessingGateway orderProcessingGateway = (OrderProcessingGateway) context
					.getBean("orderProcessingGateway");

			ThreadPoolTaskExecutor executor = (ThreadPoolTaskExecutor) context
					.getBean("taskExecutor");
			// place few test orders
			placeOrders(executor, orderProcessingGateway);

			context.stop();
			context.close();
			System.out.println("done");
		} catch (Exception ex) {
			ex.printStackTrace();
			context.stop();
			context.close();
		}

	}

	private static void placeOrders(ThreadPoolTaskExecutor executor,
			OrderProcessingGateway orderProcessingGateway) {
		executor.setWaitForTasksToCompleteOnShutdown(true);
		int i = 0;
		while (i++ < 1) {
			Order order1 = new Order(1, Order.CLEARANCE);
			order1.getItems().add(new Item("cl-drinks"));
			order1.getItems().add(new Item("cl-chips"));
			OrderProcessingJob task = new OrderProcessingJob(
					orderProcessingGateway, order1);

			executor.submit(task);

			Order order2 = new Order(2, Order.REGULAR);
			order2.getItems().add(new Item("drinks"));
			order2.getItems().add(new Item("chips"));
			task = new OrderProcessingJob(orderProcessingGateway, order2);
			executor.submit(task);

		}

		waitUntilAllTasksDie(executor);
		executor.shutdown();

	}

	private static void waitUntilAllTasksDie(ThreadPoolTaskExecutor executor) {
		while (executor.getActiveCount() != 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
