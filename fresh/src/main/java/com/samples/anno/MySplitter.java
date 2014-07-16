package com.samples.anno;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Splitter;
import org.springframework.stereotype.Component;

@MessageEndpoint
@Component
public class MySplitter {

	@Splitter(inputChannel="clearanceChannel", outputChannel="ready")
	public String splitClearance(Order order) {
		System.out.println("Splitter:: got the order"+order);
		return "<clearance>"+order + "</clearance>";
	}
}