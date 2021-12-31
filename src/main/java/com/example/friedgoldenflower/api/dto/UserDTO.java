package com.example.friedgoldenflower.api.dto;

import lombok.Data;

@Data
public class UserDTO {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 验证码
     */
    private String subject;

}
