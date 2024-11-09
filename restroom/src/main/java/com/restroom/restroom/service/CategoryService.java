package com.restroom.restroom.service;

import com.restroom.restroom.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findByMainCateCode(int mainCateCode);
}
