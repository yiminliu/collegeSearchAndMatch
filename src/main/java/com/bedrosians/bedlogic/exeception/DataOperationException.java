package com.bedrosians.bedlogic.exeception;

import org.hibernate.exception.DataException;

public class DataOperationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -34724706273251377L;
	
	DataOperationException(DataException de, String msg) {
		super(msg, de);
	}

}
