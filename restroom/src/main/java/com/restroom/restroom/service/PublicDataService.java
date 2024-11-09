package com.restroom.restroom.service;

import com.restroom.restroom.model.Pager;
import com.restroom.restroom.model.Restroom;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface PublicDataService {
    List<Restroom> reset(int categoryCode) throws IOException, NoSuchAlgorithmException, KeyManagementException;

    List<Restroom> list(Pager pager);
}
