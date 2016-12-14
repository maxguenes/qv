package com.techbeat.qv.web.util;

import com.techbeat.qv.models.Status;

public class StatusConverter {

	public static String getName(Integer statusValue){
		Status status = Status.getStatusFromValue(statusValue);
		if(status == null){
			return "";
		}
		
		return status.getStatusMsg();
	}
	
}
