package com.yunshan.tech.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunshan.tech.dao.ProductMapper;
import com.yunshan.tech.model.Product;
import com.yunshan.tech.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService{

    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> selectAll() {
        return productMapper.selectAll();
    }
}
