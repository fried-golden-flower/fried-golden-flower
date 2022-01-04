package com.example.friedgoldenflower.app.service;

import com.example.friedgoldenflower.domain.entity.Hourse;
import com.example.friedgoldenflower.domain.entity.User;

public interface HourseService {

    /**
     * 创建房间
     * @return
     */
    public Hourse createHourse(User user);
}
