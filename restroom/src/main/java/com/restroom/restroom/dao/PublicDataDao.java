package com.restroom.restroom.dao;

import com.restroom.restroom.model.Pager;
import com.restroom.restroom.model.Restroom;

import java.util.List;

public interface PublicDataDao {
    int total(Pager pager);

    List<Restroom> list(Pager pager);

    void add(Restroom item);
}
