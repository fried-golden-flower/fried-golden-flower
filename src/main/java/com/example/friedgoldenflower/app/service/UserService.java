package com.example.friedgoldenflower.app.service;

import com.example.friedgoldenflower.api.dto.Result;
import com.example.friedgoldenflower.api.dto.UserDTO;

public interface UserService {

    /**
     * 发送邮箱验证码
     * @param userDTO
     * @return
     */
    Result sendEmailCode(UserDTO userDTO);

    /**
     * 校验验证码:过期时间2分钟
     * @param userDTO
     * @return
     */
    Result checkRegister(UserDTO userDTO);

    /**
     * 注册用户
     * @param userDTO
     * @return
     */
    Result register(UserDTO userDTO);

    /**
     * 登录用户
     * @param userDTO
     * @return
     */
    Result login(UserDTO userDTO);
}
