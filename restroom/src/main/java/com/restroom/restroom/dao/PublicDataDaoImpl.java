package com.restroom.restroom.dao;

import com.restroom.restroom.model.Pager;
import com.restroom.restroom.model.Restroom;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PublicDataDaoImpl implements  PublicDataDao{
    final SqlSession sql;

    public PublicDataDaoImpl(SqlSession sql){
        this.sql=sql;
    }


    @Override
    public int total(Pager pager) {
        return sql.selectOne("restroom.total",pager);
    }

    @Override
    public List<Restroom> list(Pager pager) {
        return sql.selectList("restroom.list",pager);
    }

    @Override
    public void add(Restroom item) {
        sql.insert("restroom.add",item);
    }
}
