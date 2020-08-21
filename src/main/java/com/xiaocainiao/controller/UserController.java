package com.xiaocainiao.controller;

import com.xiaocainiao.mapper.UserMapper;
import com.xiaocainiao.model.User;
import com.xiaocainiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据ID获取用户信息
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable(value = "id") Integer id){

        return  userService.getUserById(id);
    }

    /**
     * 新增用户信息，返回主键ID
     * @param user
     * @return
     */
    @ResponseBody
    @GetMapping("/user")
    public Integer saveUser(User user){
        return userService.saveUser(user);
    }
}
