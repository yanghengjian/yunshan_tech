package com.yunshan.tech.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunshan.tech.dao.UserMapper;
import com.yunshan.tech.model.User;
import com.yunshan.tech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.UUID;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    public User login(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userMapper.selectOne(queryWrapper);
        if (user != null && user.getPassword().equals(password)) {
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setTokenExpiry(LocalDateTime.now().plusHours(1));
            userMapper.updateById(user);
            return user;
        }
        return null;
    }

    public void logout(Long userId) {
        User user = userMapper.selectById(userId);
        if (user != null) {
            user.setToken(null);
            user.setTokenExpiry(null);
            userMapper.updateById(user);
        }
    }

    @Override
    public boolean isValidToken(String token) {
        if(token ==null || token.equals("")){
            return false;
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("token",token);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            return false;
        }

        // 检查Token是否过期
        LocalDateTime tokenExpiry = user.getTokenExpiry();
        return tokenExpiry != null && tokenExpiry.isAfter(LocalDateTime.now());
    }

}
