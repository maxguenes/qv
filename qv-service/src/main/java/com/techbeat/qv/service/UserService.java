package com.techbeat.qv.service;

import java.util.List;

import com.techbeat.qv.models.User;

public interface UserService {
	List<User> list();
	User find(int id);
	User save(User user);
	boolean delete(int id);
}
