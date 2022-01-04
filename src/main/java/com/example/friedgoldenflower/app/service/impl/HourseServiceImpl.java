package com.example.friedgoldenflower.app.service.impl;

import com.example.friedgoldenflower.api.dto.Result;
import com.example.friedgoldenflower.app.service.HourseService;
import com.example.friedgoldenflower.common.utils.HourseCodeUtils;
import com.example.friedgoldenflower.domain.entity.Hourse;
import com.example.friedgoldenflower.domain.entity.User;
import com.example.friedgoldenflower.domain.repository.HourseRespository;
import com.example.friedgoldenflower.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class HourseServiceImpl implements HourseService {

    @Autowired
    private HourseRespository hourseRespository;
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result createHourse(User user) {
        Result result = new Result();
        //校验
        Hourse checkHourse = hourseRespository.selectHourseByUserId(user.getId());
        if (!Objects.isNull(checkHourse)) {
            result.setSuccess(false);
            result.setMsg("用户已经在房间中");
            result.setContent(checkHourse);
            return result;
        }
        Hourse hourse = new Hourse();
        hourse.setHourseName(user.getUserName() + "创建的房间");
        hourse.setHourseCode(HourseCodeUtils.getHourseCode("-1"));
        hourse.setCreateTime(new Date());
        hourse.setCreateUser(user.getId());
        hourse.setHourseUser(user.getId() + "");
        hourseRespository.createHourse(hourse);
        //更新用户所在的当前房间的ID
        userRepository.updateUserCurHourse(hourse.getId(), user.getId());
        HourseCodeUtils.put(hourse.getHourseCode(), hourse.getId());
        result.setSuccess(true);
        result.setMsg("创建房间成功");
        result.setContent(hourse);
        return result;
    }
}
