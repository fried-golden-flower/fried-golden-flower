package com.example.friedgoldenflower.domain.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 当前房间
     */
    private Long curHourse;
    /**
     * 拥有房卡数
     */
    private Long hourseCard;
}
