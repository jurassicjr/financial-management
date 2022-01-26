package br.com.alexandre.financialmanagement.shared.error;

import java.io.Serializable;

public class WSException extends Exception implements Serializable {

	private static final long serialVersionUID = 5656611660718088637L;

	public WSException() {
		super();
	}

	public WSException(String msg) {
		super(msg);
	}

	public WSException(String msg, Exception e) {
		super(msg, e);
	}
}
