package com.yunshan.tech.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunshan.tech.dao.ProductMapper;
import com.yunshan.tech.model.Product;
import com.yunshan.tech.model.User;
import com.yunshan.tech.service.ProductService;
import com.yunshan.tech.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService{

    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> selectList(ProductVo productVo) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        if (productVo.getName() != null && !productVo.getName().isEmpty()) {
            queryWrapper.like("name", productVo.getName());
        }
        if (productVo.getSpecification() != null && !productVo.getSpecification().isEmpty()) {
            queryWrapper.like("specification", productVo.getSpecification());
        }
        if (productVo.getCondition() != null && !productVo.getCondition().isEmpty()) {
            queryWrapper.eq("condition", productVo.getCondition());
        }
        if (productVo.getMinPrice() != null) {
            queryWrapper.ge("price", productVo.getMinPrice());
        }
        if (productVo.getMaxPrice() != null) {
            queryWrapper.le("price", productVo.getMaxPrice());
        }
        if (productVo.getContact() != null && !productVo.getContact().isEmpty()) {
            queryWrapper.like("contact", productVo.getContact());
        }
        if (productVo.getIsShow() != null) {
            queryWrapper.eq("is_show", productVo.getIsShow());
        }

        return productMapper.selectList(queryWrapper);
    }
}
