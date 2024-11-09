package com.restroom.restroom.dao;

import com.restroom.restroom.model.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> findByMainCateCode(int mainCateCode);
}
