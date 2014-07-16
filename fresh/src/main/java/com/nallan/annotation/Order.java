package com.nallan.annotation;

import java.util.ArrayList;
import java.util.List;

public class Order {

	public static final String REGULAR = "REGULAR";
	public static final String CLEARANCE = "CLEARANCE";

	private int id;
	private String type;

	private List<Item> items = new ArrayList<Item>();

	public Order(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [id=").append(id).append(", type=").append(type)
				.append(", items=").append(items).append("]");
		return builder.toString();
	}

	

}
