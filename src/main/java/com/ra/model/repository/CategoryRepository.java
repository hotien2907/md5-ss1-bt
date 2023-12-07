package com.ra.model.repository;
import com.ra.model.entity.Category;
import java.util.List;


public interface CategoryRepository {

    List<Category> findAll();
    Boolean saveOrUpdate(Category category);
    Boolean  delete (Integer id);
    Category findById(Integer id);
}
