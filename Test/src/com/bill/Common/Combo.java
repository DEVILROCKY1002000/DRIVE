package com.bill.Common;


public class Combo {
	
private int index;
private String value;


public Combo(int key, String value) {
	this.index = key;
	this.value = value;
}

public int getIndex() {
	return index;
}

public String getValue() {
	return value;
}

@Override
public String toString() {
	return this.value;
}

	

}
