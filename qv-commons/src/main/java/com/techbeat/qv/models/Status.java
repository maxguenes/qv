package com.techbeat.qv.models;

public enum Status {

	INSUFFICIENT_STOCK(-1),
	WAITING_PAYMENT(1),
	WAITING_CAR(2),
	IN_DELIVERY(3),
	DELIVERED(0);
	
	private Integer statusValue;
	
	Status (Integer statusValue){
		this.statusValue = statusValue;
	}

	public Integer getStatusValue() {
		return statusValue;
	}
	
	

}
