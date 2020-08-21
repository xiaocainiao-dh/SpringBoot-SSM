package com.xiaocainiao.service;

import com.xiaocainiao.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    /**
     * 根据ID获取用户信息
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 信息用户信息
     * @param user
     * @return
     */
    Integer saveUser(User user);

}
