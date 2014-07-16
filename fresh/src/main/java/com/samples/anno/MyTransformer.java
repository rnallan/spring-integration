package com.samples.anno;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;

@MessageEndpoint
public class MyTransformer {

	@Transformer(inputChannel = "regularChannel", outputChannel = "ready")
	public String transform(Order message) {
		System.out.println("Trasnformer::Got the message " + message
				+ ",transforming to clearance ");
		return "<TClearance>" + message + "</TClearance>";
	}
}
