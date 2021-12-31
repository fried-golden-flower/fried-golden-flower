package com.example.friedgoldenflower.infra.repository.impl;

import com.example.friedgoldenflower.domain.entity.Hourse;
import com.example.friedgoldenflower.domain.repository.HourseRespository;
import com.example.friedgoldenflower.infra.mapper.HourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HourseRespositoryImpl implements HourseRespository {

    @Autowired
    private HourseMapper hourseMapper;

    @Override
    public Hourse createHourse(Hourse hourse) {
        return hourseMapper.createHourse(hourse);
    }
}
