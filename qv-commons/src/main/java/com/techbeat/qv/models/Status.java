package com.techbeat.qv.models;

public enum Status {

	AGUARDANDO_PAGAMENTO(1);
	
	private Integer valor;

	
	Status (Integer valor){
		this.valor = valor;
	}

	public Integer getValor() {
		return valor;
	}
	
	
	
	

}
