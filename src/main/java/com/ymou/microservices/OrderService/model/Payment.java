package com.ymou.microservices.OrderService.model;

public class Payment {

	private int id;	
	private int OrderId;
	private double amount;
	private String paymentStatus;
	private String transactionId;
	
	
	public Payment() {
		
	}
	
	public Payment(int id, int orderId, double amount, String paymentStatus, String transactionId) {
		super();
		this.id = id;
		OrderId = orderId;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
		this.transactionId = transactionId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	
}