package com.techbeat.qv.database.repository;

import org.springframework.data.repository.CrudRepository;

import com.techbeat.qv.database.entity.StockEntity;

/**
 * Created by Max Guenes on 04/12/2016.
 */
public interface StockRepository extends CrudRepository<StockEntity, Integer> {

	StockEntity findByProduct_id(Integer id);
	
}
