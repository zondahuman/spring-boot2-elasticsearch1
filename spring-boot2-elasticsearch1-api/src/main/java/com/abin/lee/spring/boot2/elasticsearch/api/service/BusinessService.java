package com.abin.lee.spring.boot2.elasticsearch.api.service;

import com.abin.lee.spring.boot2.elasticsearch.api.entity.Business;

import java.util.List;

/**
 * Created by abin on 2019/7/13.
 */
public interface BusinessService {

    void insert(Business model);

    void index(Business model);

    List<Business> findByName(String name);

    List<Business> findByPriceBetween(Double startPrice, Double endPrice);





}
