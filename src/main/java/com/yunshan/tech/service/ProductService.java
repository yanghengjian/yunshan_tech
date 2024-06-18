package com.yunshan.tech.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yunshan.tech.model.Product;
import com.yunshan.tech.vo.ProductVo;

import java.util.List;

public interface ProductService extends IService<Product> {

    List<Product> selectList(ProductVo productVo);
}
