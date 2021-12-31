package com.example.friedgoldenflower.infra.mapper;

import com.example.friedgoldenflower.api.dto.UserDTO;
import com.example.friedgoldenflower.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    /**
     * 查询用户信息
     * @param userDTO
     * @return
     */
    User selectUser(UserDTO userDTO);

    /**
     * 注册用户-插入
     * @param userDTO
     * @return
     */
    Integer insertUser(UserDTO userDTO);

    /**
     * 登录用户
     * @param userDTO
     * @return
     */
    User login(UserDTO userDTO);
}
