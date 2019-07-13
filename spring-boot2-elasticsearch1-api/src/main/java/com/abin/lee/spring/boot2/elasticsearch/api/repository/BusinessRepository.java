package com.abin.lee.spring.boot2.elasticsearch.api.repository;

import com.abin.lee.spring.boot2.elasticsearch.api.entity.Business;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by abin on 2019/7/13.
 */
@Repository
public interface BusinessRepository extends ElasticsearchRepository<Business, Long> {

    List<Business> findByName(String name);
    List<Business> findByPriceBetween(Double start, Double end);



}
