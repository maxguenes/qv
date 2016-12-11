package com.techbeat.qv.database.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.techbeat.qv.database.entity.ProductOrderEntity;
import com.techbeat.qv.database.entity.UserEntity;

/**
 * Created by Max Guenes on 04/12/2016.
 */
public interface ProductOrderRepository extends CrudRepository<ProductOrderEntity, Integer> {

	List<ProductOrderEntity> findByUser(UserEntity user);
	
	List<ProductOrderEntity> findByUser_email(String email);
	
}
