package com.restroom.restroom.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class PublicDataDaoImpl implements  PublicDataDao{
    final SqlSession sql;

    public PublicDataDaoImpl(SqlSession sql){
        this.sql=sql;
    }


}
