package com.abin.lee.spring.boot2.elasticsearch.api.repository;

import com.abin.lee.spring.boot2.elasticsearch.api.entity.Business;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by abin on 2019/7/13.
 */
@Repository
public interface BusinessRepository extends ElasticsearchRepository<Business, Long> {

    List<Business> findByName(String name);
    List<Business> findByRatingBetween(Double start, Double end);



}
