package com.example.friedgoldenflower.app.service.impl;

import com.example.friedgoldenflower.api.dto.Result;
import com.example.friedgoldenflower.api.dto.UserDTO;
import com.example.friedgoldenflower.app.service.RegisterCodeService;
import com.example.friedgoldenflower.domain.entity.RegisterCode;
import com.example.friedgoldenflower.domain.repository.RegisterCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegisterCodeServiceImpl implements RegisterCodeService {

    @Autowired
    private RegisterCodeRepository registerCodeRepository;

    @Override
    public Result checkRegisterCode(UserDTO userDTO) {
        Result result = new Result();
        RegisterCode registerCode = registerCodeRepository.selectRegisterCodeByEmail(userDTO.getEmail());
        Date createTime = registerCode.getCreateTime();
        if (System.currentTimeMillis() - createTime.getTime() > 1000L * 60 * 2) {
            result.setSuccess(false);
            result.setContent("验证码已经过期(超过两分钟)");
            return result;
        }
        String code = registerCode.getCode();
        if (!code.equals(userDTO.getSubject())) {
            result.setSuccess(false);
            result.setContent("验证码不匹配");
            return result;
        }
        result.setSuccess(true);
        result.setContent("验证码匹配成功");
        return result;
    }
}
