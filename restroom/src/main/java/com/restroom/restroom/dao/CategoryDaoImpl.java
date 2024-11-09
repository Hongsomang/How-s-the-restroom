package com.restroom.restroom.dao;

import com.restroom.restroom.model.Category;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao{
    SqlSession sql;
    public CategoryDaoImpl(SqlSession sql){
        this.sql=sql;
    }

    @Override
    public List<Category> findByMainCateCode(int mainCateCode) {
        return sql.selectList("category.findByMainCateCode",mainCateCode);
    }
}
