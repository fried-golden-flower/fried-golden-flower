package com.example.friedgoldenflower.app.service.impl;

import com.example.friedgoldenflower.app.service.HourseService;
import com.example.friedgoldenflower.common.utils.HourseCodeUtils;
import com.example.friedgoldenflower.domain.entity.Hourse;
import com.example.friedgoldenflower.domain.entity.User;
import com.example.friedgoldenflower.domain.repository.HourseRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class HourseServiceImpl implements HourseService {

    @Autowired
    private HourseRespository hourseRespository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Hourse createHourse(User user) {
        Hourse hourse = new Hourse();
        hourse.setHourseName(user.getUserName()+"创建的房间");
        hourse.setHourseCode(HourseCodeUtils.getHourseCode(new Object()));
        hourse.setCreateTime(new Date());
        hourse.setCreateUser(user.getId());
        hourse.setHourseUser(user.getId()+"");
//        hourseRespository.save(hourse);
        return null;
    }
}
