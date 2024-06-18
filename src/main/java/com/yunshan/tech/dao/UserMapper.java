package com.yunshan.tech.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunshan.tech.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
