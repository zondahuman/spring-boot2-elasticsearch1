package com.abin.lee.spring.boot2.elasticsearch.api.service.impl;

import com.abin.lee.spring.boot2.elasticsearch.api.entity.Business;
import com.abin.lee.spring.boot2.elasticsearch.api.repository.BusinessRepository;
import com.abin.lee.spring.boot2.elasticsearch.api.service.BusinessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by abin on 2019/7/13.
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    @Resource
    BusinessRepository businessRepository ;
    @Override
    public void insert(Business model) {
        this.businessRepository.save(model);
    }

    @Override
    public void index(Business model) {
        this.businessRepository.index(model);
    }


















































}
