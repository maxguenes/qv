package com.techbeat.qv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techbeat.qv.database.entity.UserEntity;
import com.techbeat.qv.database.repository.UserRepository;
import com.techbeat.qv.models.User;
import com.techbeat.qv.service.UserService;
import com.techbeat.qv.service.converter.UserConverter;

@Component
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepository; 
	
	@Override
	public List<User> list() {
		Iterable<UserEntity> found = userRepository.findAll();
		return UserConverter.convertToModelList(found);
	}

	@Override
	public User find(int id) {
		return UserConverter.convert(userRepository.findOne(id));
	}

	@Override
	public User save(User user) {
		UserEntity entity = UserConverter.convert(user);
		return UserConverter.convert(userRepository.save(entity));
		
	}

	@Override
	public boolean delete(int id) {
		userRepository.delete(id);
		return true;
	}

}
