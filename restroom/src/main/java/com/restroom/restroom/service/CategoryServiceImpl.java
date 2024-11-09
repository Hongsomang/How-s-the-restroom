package com.restroom.restroom.service;

import com.restroom.restroom.dao.CategoryDao;
import com.restroom.restroom.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    final CategoryDao categoryDao;
    public CategoryServiceImpl(CategoryDao categoryDao){
        this.categoryDao=categoryDao;
    }
    @Override
    public List<Category> findByMainCateCode(int mainCateCode) {
        return categoryDao.findByMainCateCode(mainCateCode);
    }
}
