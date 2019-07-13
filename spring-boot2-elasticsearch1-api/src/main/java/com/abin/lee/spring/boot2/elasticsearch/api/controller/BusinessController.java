package com.abin.lee.spring.boot2.elasticsearch.api.controller;

import com.abin.lee.spring.boot2.elasticsearch.api.entity.Business;
import com.abin.lee.spring.boot2.elasticsearch.api.service.BusinessService;
import com.abin.lee.spring.boot2.elasticsearch.common.base.BaseExtends;
import com.abin.lee.spring.boot2.elasticsearch.common.generator.SnowflakeIdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by abin on 2019/7/13.
 */
@RestController
@RequestMapping("/business")
@Slf4j
@Api("BusinessController--api")
public class BusinessController {

    @Resource
    BusinessService businessService;

    @ApiOperation(value = "增加商品", notes = "增加商品")
    @PostMapping(value = "/addBusiness")
    public String addBusiness(String name, Double price) {
        log.info("addBusiness--name=" + name + ",price=" + price);
        try {
            Business business = new Business();
            business.setName(name);
            business.setPrice(price);
            Long id = SnowflakeIdWorker.getId();
            business.setId(id);
            this.businessService.insert(business);
        } catch (Exception e) {
            log.error("addBusiness--name=" + name + ",price=" + price + "e=" + e);
            return BaseExtends.error();
        }
        return BaseExtends.success();
    }


    @ApiOperation(value = "findByName", notes = "findByName")
    @GetMapping(value = "/findByName")
    public String findByName(String name) {
        log.info("findByName--name=" + name);
        List<Business> businessList = null;
        try {
            businessList = this.businessService.findByName(name);
        } catch (Exception e) {
            log.error("findByName--name=" + name + "e=" + e);
            return BaseExtends.error();
        }
        return BaseExtends.success(businessList);
    }


    @ApiOperation(value = "findByPriceBetween", notes = "findByPriceBetween")
    @GetMapping(value = "/findByPriceBetween")
    public String findByPriceBetween(Double startPrice, Double endPrice) {
        log.info("findByPriceBetween--startPrice=" + startPrice+",endPrice="+endPrice);
        List<Business> businessList = null;
        try {
            businessList = this.businessService.findByPriceBetween(startPrice, endPrice);
        } catch (Exception e) {
            log.error("findByPriceBetween--price="+ startPrice+",endPrice="+endPrice + "e=" + e);
            return BaseExtends.error();
        }
        return BaseExtends.success(businessList);
    }


}
