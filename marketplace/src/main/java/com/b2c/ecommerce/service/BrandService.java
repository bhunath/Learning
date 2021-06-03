package com.b2c.ecommerce.service;

import com.b2c.ecommerce.entity.Brand;
import com.b2c.ecommerce.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    BrandRepository brandRepository;

    public List<Brand> findAll(){
        String a = new String("a").intern();
        a.intern();
        return brandRepository.findAll();

    }
}
