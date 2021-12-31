package com.example.friedgoldenflower.domain.entity;

import lombok.Data;

import java.util.Date;

@Data
public class RegisterCode {
    private Long id;
    private String email;
    private String code;
    private Date createTime;

}
