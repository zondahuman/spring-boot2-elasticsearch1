package com.abin.lee.spring.boot2.elasticsearch.api.controller;

import com.abin.lee.spring.boot2.elasticsearch.api.entity.Business;
import com.abin.lee.spring.boot2.elasticsearch.api.service.BusinessService;
import com.abin.lee.spring.boot2.elasticsearch.common.base.BaseExtends;
import com.abin.lee.spring.boot2.elasticsearch.common.generator.SnowflakeIdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by abin on 2019/7/13.
 */
@RestController
@RequestMapping("/business")
@Slf4j
@Api("BusinessController--api")
public class BusinessController {

    @Resource
    BusinessService businessService ;

    @ApiOperation(value = "增加商品", notes = "增加商品")
    @PostMapping(value = "/addBusiness")
    public String addBusiness(String name, Double price) {
        log.info("addBusiness--name="+name+",price="+price);
        try {
            Business business = new Business();
            business.setName(name);
            business.setPrice(price);
            Long id = SnowflakeIdWorker.getId();
            business.setId(id);
            this.businessService.insert(business);
        } catch (Exception e) {
            log.error("addBusiness--name="+name+",price="+price + "e=" + e);
            return BaseExtends.error();
        }
        return BaseExtends.success();
    }






















}
