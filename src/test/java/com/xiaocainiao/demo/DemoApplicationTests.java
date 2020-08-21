package com.xiaocainiao.demo;


import com.xiaocainiao.mapper.UserMapper;
import com.xiaocainiao.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testMapper(){
        User user = userMapper.getUserById(1);
        System.out.println(user);
    }

}
