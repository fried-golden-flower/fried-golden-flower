package com.example.friedgoldenflower.domain.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Hourse {
    private Long id;

    /**
     * 房间名称-默认为房主名称+'创建的房间'
     */
    private String hourseName;


    /**
     * 房间编号-六位数字
     */
    private String hourseCode;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 创建用户:房主
     */
    private Long createUser;

    /**
     * 当前房间的用户id: id1,id2,id3..
     */
    private String hourseUser;

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", hourseName: '" + hourseName + '\'' +
                ", hourseCode: '" + hourseCode + '\'' +
                ", createTime: '" + createTime + '\'' +
                ", createUser: '" + createUser + '\'' +
                ", hourseUser: '" + hourseUser + '\'' +
                '}';
    }
}
