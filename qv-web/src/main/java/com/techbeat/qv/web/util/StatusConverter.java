package com.techbeat.qv.web.util;

import com.techbeat.qv.models.Status;

public class StatusConverter {

	public String getName(Integer statusValue){
		return Status.getStatusFromValue(statusValue).getStatusMsg();
	}
	
}
