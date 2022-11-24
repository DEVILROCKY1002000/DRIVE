package com.bill.Common;

import java.text.DecimalFormat;

import com.bill.Start.Appstart;

public class Appcommon {

	public static String billing = Appstart.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "Billing.jar";
	public static int operCode;
	public static String customerID;
	public static String functionCode;
	public static DecimalFormat amountFormat = new DecimalFormat("#0.00");
	public static DecimalFormat weightFormat = new DecimalFormat("#0.000");
	public static DecimalFormat zeroFormat = new DecimalFormat("#0");
}
