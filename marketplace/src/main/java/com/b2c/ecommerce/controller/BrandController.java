package com.b2c.ecommerce.controller;

import com.b2c.ecommerce.entity.Brand;
import com.b2c.ecommerce.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrandController {

    @Autowired
    BrandService brandService;

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public String info(){
        return "I am B2C ECommerce Market Controller";
    }

    @RequestMapping(value = "/fetchAllBrands",method = RequestMethod.GET)
    public List<Brand> fetchAllBrands(){
        return brandService.findAll();
    }
}
