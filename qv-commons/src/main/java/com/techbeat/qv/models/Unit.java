package com.techbeat.qv.models;

public enum Unit {

	
	KG("Kg"),
	G("g"),
	UNIT("Unid.");
	
	private String unitName;

	Unit (String unitName){
		this.unitName = unitName;
	}

	public String getUnitName() {
		return unitName;
	}
	
	

}
