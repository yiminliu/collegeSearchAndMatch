package com.bedrosians.bedlogic.util;

public enum Status {

	ACTIVE("ACTIVE"),
	INACTIVE("INACTIVE"),
	DISCONTINUED("DISCONTINUED"),
	DELETED("DELETED");
		
	private String name;
	private Status(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
