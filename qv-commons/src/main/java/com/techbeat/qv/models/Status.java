package com.techbeat.qv.models;

public enum Status {

	INSUFFICIENT_STOCK(-1, "Estoque Insuficiente"),
	WAITING_PAYMENT(1, "Aguardando pagamento"),
	WAITING_CAR(2, "Aguardando entrega"),
	IN_DELIVERY(3, "Em entrega"),
	DELIVERED(0, "Entregue");
	
	private Integer statusValue;
	private String statusMsg;
	
	Status (Integer statusValue, String statusMsg){
		this.statusValue = statusValue;
		this.statusMsg = statusMsg;
	}

	public Integer getStatusValue() {
		return statusValue;
	}
	
	public String getStatusMsg() {
		return statusMsg;
	}
	
	public static Status getStatusFromValue(Integer statusValue){
		for(Status status : values()){
			if(status.getStatusValue() == statusValue){
				return status;
			}
		}
		return null;
	}
	

}
