package com.ra.model.repository;

import com.ra.model.entity.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> getAll();
    public Boolean create(Product product);
    public Product find(Integer productID);
    public Boolean update(Product product);
    public Boolean delete(Integer productID);
}
