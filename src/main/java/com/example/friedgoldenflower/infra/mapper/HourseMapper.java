package com.example.friedgoldenflower.infra.mapper;

import com.example.friedgoldenflower.domain.entity.Hourse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HourseMapper {
    /**
     * 创建房间
     * @return
     */
    Integer createHourse(Hourse hourse);

    Hourse selectHourseById(Long id);
}
