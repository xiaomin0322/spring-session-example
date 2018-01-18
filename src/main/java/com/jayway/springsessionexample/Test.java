package com.jayway.springsessionexample;

import java.io.Serializable;

public class Test implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name  = "123";
	private T t = new T();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	

}

class T implements Serializable{
	private String n="1231";

	public String getN() {
		return n;
	}

	public void setN(String n) {
		this.n = n;
	}
	
}
