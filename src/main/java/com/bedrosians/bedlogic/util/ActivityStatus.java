package com.bedrosians.bedlogic.util;

public enum ActivityStatus {

	ACTIVE("ACTIVE"),
	INACTIVE("INACTIVE");
		
	private String name;
	private ActivityStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
