package com.techbeat.qv.database.repository;

import com.techbeat.qv.database.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Max Guenes on 04/12/2016.
 */
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {

}
