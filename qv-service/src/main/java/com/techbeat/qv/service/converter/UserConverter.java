package com.techbeat.qv.service.converter;

import java.util.ArrayList;
import java.util.List;

import com.techbeat.qv.database.entity.UserEntity;
import com.techbeat.qv.models.User;

public class UserConverter {
	public static User convert(UserEntity p)
	{
		
		if(p==null){
			return null;
		}
		
		User result = new User();
		
		result.setId(p.getId());
		result.setEmail(p.getEmail());
		result.setName(p.getName());
		result.setRegisterDate(p.getRegisterDate());
		
		return result;
	}
	
	public static List<User> convertToModelList(Iterable<UserEntity> p)
	{
		
		if(p == null){
			return null;
		}
		
		List<User> result = new ArrayList<>();
		for(UserEntity entity : p){
			result.add(convert(entity));
		}
		
		return result;
	}
	
	public static UserEntity convert(User p)
	{
		
		if(p == null){
			return null;
		}
		
		UserEntity result = new UserEntity();
		
		result.setId(p.getId());
		result.setEmail(p.getEmail());
		result.setName(p.getName());
		result.setRegisterDate(p.getRegisterDate());
		
		return result;
	}
}
