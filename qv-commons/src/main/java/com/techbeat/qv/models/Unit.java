package com.techbeat.qv.models;

public enum Unit {

	
	KG("Kg"),
	G("Grama"),
	UNIT("Unid.");
	
	private String unitName;

	Unit (String unitName){
		this.unitName = unitName;
	}

	public String getUnitName() {
		return unitName;
	}

}
