package com.bill.Common;

public enum Position {

	POS1(10), POS2(100), POS3(120), POS4(150), PAGECENTER(75);
	
	int x;
	private Position(int position) {
		this.x = position;
	}
}
