package com.example.demo.repository;

import com.example.demo.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Integer> {

    @Query
    public List<Products> findByName(String name);

    @Query
    public List<Products> findByPrice(Double price);

//    @Query("select p from products p where p.price <= :price")
//    public List<Products> findByPriceLessThan(@Param("price") Double price);


}
