package com.springjourney.Week3Practice.Repositories;

import com.springjourney.Week3Practice.Entities.Product;
import com.springjourney.Week3Practice.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findByProductName(String productName);

    List<Product> findByProductNameLike(String productName);
    List<Product> findByProductNameNotLike(String productName);

    List<Product> findByProductNameStartsWith(String productName);
    List<Product> findByProductNameEndsWith(String productName);

    List<Product> findByPriceGreaterThan(float price);
    List<Product> findByPriceLessThan(float price);
    List<Product> findByPriceGreaterThanEqual(float price);
    List<Product> findByPriceLessThanEqual(float i);

    List<Product> findByPriceIsBetween(float p, float p1);

    List<Product> findByProductNameContaining(String productName);


    List<Product> findFirst5ByProductNameLike(String productName);


    List<Product> findByOrderByPriceDesc();
}
