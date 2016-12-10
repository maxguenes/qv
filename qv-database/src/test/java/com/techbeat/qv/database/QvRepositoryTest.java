package com.techbeat.qv.database;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.techbeat.qv.database.context.DatabaseContext;
import com.techbeat.qv.database.entity.ProductEntity;
import com.techbeat.qv.database.entity.ProductOrderEntity;
import com.techbeat.qv.database.entity.ProductOrderItemsEntity;
import com.techbeat.qv.database.entity.UserEntity;
import com.techbeat.qv.database.repository.ProductOrderItemsRepository;
import com.techbeat.qv.database.repository.ProductRepository;

/**
 * Created by Max Guenes on 04/09/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseContext.class, loader = AnnotationConfigContextLoader.class)
public class QvRepositoryTest {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductOrderItemsRepository productOrderItemsRepository;


    
    @Test
    @Transactional
    @Rollback(true)
    public void testInsertProduct() throws Exception
    {

        Assert.assertNotNull(productRepository);

        ProductEntity product = new ProductEntity();

        product.setName("Banana");
        product.setValue(1.10);

        ProductEntity saved = productRepository.save(product);
        Assert.assertNotNull(saved);
        Assert.assertTrue(saved.getId()>0);

        ProductEntity found = productRepository.findOne(saved.getId());
        Assert.assertNotNull(found);
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testDeleteProduct() throws Exception {
        Assert.assertNotNull(productRepository);

        ProductEntity product = new ProductEntity();

        product.setName("Laranja");
        product.setValue(2.0);

        ProductEntity saved = productRepository.save(product);
        Assert.assertNotNull(saved);
        
        productRepository.delete(saved.getId());
        
    }
    

    
       
    
    
 
}
