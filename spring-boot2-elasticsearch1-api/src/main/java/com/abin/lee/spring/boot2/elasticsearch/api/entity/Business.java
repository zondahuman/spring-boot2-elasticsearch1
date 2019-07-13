package com.abin.lee.spring.boot2.elasticsearch.api.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by abin on 2019/7/13.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "cn_beauty_business_index", type = "cn_beauty_business_type", shards = 1, replicas = 0)
public class Business {

    @Id
    private Long id;

    private String name;

    private Double price;




}
