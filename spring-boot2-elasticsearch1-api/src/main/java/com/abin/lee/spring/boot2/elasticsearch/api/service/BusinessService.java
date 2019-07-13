package com.abin.lee.spring.boot2.elasticsearch.api.service;

import com.abin.lee.spring.boot2.elasticsearch.api.entity.Business;

/**
 * Created by abin on 2019/7/13.
 */
public interface BusinessService {

    void insert(Business model);

    void index(Business model);



}
