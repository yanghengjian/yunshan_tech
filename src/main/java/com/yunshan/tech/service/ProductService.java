package com.yunshan.tech.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yunshan.tech.model.Product;

import java.util.List;

public interface ProductService extends IService<Product> {
    List<Product> selectAll();
}
