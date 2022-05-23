package com.katarilab.java8aircraft;

public interface SessionTemplate {

	Object getAttribute(String name);

	void setAttribute(String name, Object value);

	void removeAttribute(String name);

}