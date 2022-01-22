package com.spring.udemy.SpringRestFromUdemy.Filetering;

import com.fasterxml.jackson.annotation.JsonFilter;

//@JsonIgnoreProperties(value = {"val1","val2"}) // looks like we are giving statically
@JsonFilter("SomeBeanFilter")
public class SomeBean {

	private String val1;
	private String val2;
	//@JsonIgnore -- static filtering
	private String val3;

	public SomeBean(String val1, String val2, String val3) {
		super();
		this.val1 = val1;
		this.val2 = val2;
		this.val3 = val3;
	}

	public String getVal1() {
		return val1;
	}

	public String getVal2() {
		return val2;
	}

	public String getVal3() {
		return val3;
	}

	@Override
	public String toString() {
		return "SomeBean [val1=" + val1 + ", val2=" + val2 + ", val3=" + val3 + "]";
	}

}
