package com.bedrosians.bedlogic.util;

public enum PatternMatchMode {

	START("Start"),
	END("End"),
	ANYWHERE("Anywhere"),
	NONE("None");
	
	private String name;
	private PatternMatchMode(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
