package com.xiaocainiao.service.impl;

import com.xiaocainiao.mapper.UserMapper;
import com.xiaocainiao.model.User;
import com.xiaocainiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(cacheManager = "userCacheManager",value = "user",key = "#root.methodName + '[' + #id + ']'")
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public Integer saveUser(User user) {
        userMapper.saveUser(user);

        return user.getId();
    }

}
