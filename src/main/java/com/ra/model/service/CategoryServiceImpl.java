package com.ra.model.service;

import com.mysql.cj.xdevapi.SessionFactory;
import com.ra.model.entity.Category;
import com.ra.model.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService{

   @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
     return    categoryRepository.findAll();
    }

    @Override
    public Boolean saveOrUpdate(Category category) {
     return    categoryRepository.saveOrUpdate(category);
    }

    @Override
    public void delete(Integer id) {
          categoryRepository.delete(id);
    }

    @Override
    public Category findById(Integer id) {
      return categoryRepository.findById(id);
    }
}
