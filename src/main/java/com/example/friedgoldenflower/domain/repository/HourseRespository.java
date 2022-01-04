package com.example.friedgoldenflower.domain.repository;

import com.example.friedgoldenflower.domain.entity.Hourse;

public interface HourseRespository {

    /**
     * 创建房间
     *
     * @return
     */
    Integer createHourse(Hourse hourse);

    /**
     * 通过用户id,查询房间
     * @param userId
     * @return
     */
    Hourse selectHourseByUserId(Long userId);
}
