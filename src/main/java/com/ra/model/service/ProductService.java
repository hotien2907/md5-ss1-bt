package com.ra.model.service;

import com.ra.model.entity.Product;

import java.util.List;

public interface ProductService {
     List<Product> getAll();
     Boolean create(Product product);
     Integer find(Integer productID);
     Boolean update(Product product);
     Boolean delete(Integer productID);
}
