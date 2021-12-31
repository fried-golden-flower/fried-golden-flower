package com.example.friedgoldenflower.app.service.impl;

import com.example.friedgoldenflower.app.service.HourseService;
import com.example.friedgoldenflower.domain.entity.Hourse;
import com.example.friedgoldenflower.domain.repository.HourseRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HourseServiceImpl implements HourseService {

    @Autowired
    private HourseRespository hourseRespository;
    @Override
    public Hourse createHourse() {
        Hourse hourse = new Hourse();

        return null;
    }
}
