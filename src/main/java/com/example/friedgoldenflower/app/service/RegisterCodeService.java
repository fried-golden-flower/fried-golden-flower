package com.example.friedgoldenflower.app.service;

import com.example.friedgoldenflower.api.dto.Result;
import com.example.friedgoldenflower.api.dto.UserDTO;

public interface RegisterCodeService {
    /**
     * 校验邮箱验证码-过期时间2分钟
     * @param userDTO
     * @return
     */
    Result checkRegisterCode(UserDTO userDTO);
}
