package com.example.friedgoldenflower.app.service;

import com.example.friedgoldenflower.api.dto.Result;
import com.example.friedgoldenflower.domain.entity.User;

public interface HourseService {

    /**
     * 创建房间
     * @return
     */
    public Result createHourse(User user);
}
