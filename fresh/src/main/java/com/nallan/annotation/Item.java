package com.nallan.annotation;

public class Item {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Item(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [name=").append(name).append("]");
		return builder.toString();
	}

}
