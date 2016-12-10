package com.techbeat.qv.database.repository;

import org.springframework.data.repository.CrudRepository;

import com.techbeat.qv.database.entity.UserEntity;

/**
 * Created by Max Guenes on 04/12/2016.
 */
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

	UserEntity findByEmail(String email);
}
