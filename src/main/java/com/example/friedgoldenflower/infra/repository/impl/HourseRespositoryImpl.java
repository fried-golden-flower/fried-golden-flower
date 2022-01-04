package com.example.friedgoldenflower.infra.repository.impl;

import com.example.friedgoldenflower.domain.entity.Hourse;
import com.example.friedgoldenflower.domain.entity.User;
import com.example.friedgoldenflower.domain.repository.HourseRespository;
import com.example.friedgoldenflower.infra.mapper.HourseMapper;
import com.example.friedgoldenflower.infra.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class HourseRespositoryImpl implements HourseRespository {

    @Autowired
    private HourseMapper hourseMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer createHourse(Hourse hourse) {
        return hourseMapper.createHourse(hourse);
    }

    @Override
    public Hourse selectHourseByUserId(Long userId) {
        User user = userMapper.selectUserById(userId);
        if(Objects.isNull(user.getCurHourse())){
            return null;
        }else{
            return hourseMapper.selectHourseById(user.getCurHourse());
        }
    }
}
