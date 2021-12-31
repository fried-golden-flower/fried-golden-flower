package com.example.friedgoldenflower.api.dto;

import lombok.Data;

@Data
public class Result {
    /**
     * 处理成功/失败
     */
    private Boolean success;
    /**
     * 处理后的内容
     */
    private Object content;

}
