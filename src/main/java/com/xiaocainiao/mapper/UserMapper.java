package com.xiaocainiao.mapper;

import com.xiaocainiao.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    /**
     * 根据主键ID获取用户信息
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 新增用户信息，并返回自增的主键ID
     * @param user
     * @return
     */
    Integer saveUser(User user);
}
