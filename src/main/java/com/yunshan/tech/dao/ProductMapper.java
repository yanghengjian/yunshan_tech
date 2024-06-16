package com.yunshan.tech.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunshan.tech.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    List<Product> selectAll();

}
