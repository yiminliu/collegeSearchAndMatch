package com.bedrosians.bedlogic.util;

public enum RestrictionOperation {

	EQ("eq"),
	NE("ne"),
	IN("in"),
	NULL("null"),
	NOTNULL("not_null"),
	NONE("none");
	
	private String name;
	private RestrictionOperation(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
