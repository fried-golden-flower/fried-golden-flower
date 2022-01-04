package com.example.friedgoldenflower.domain.repository;

import com.example.friedgoldenflower.api.dto.UserDTO;
import com.example.friedgoldenflower.domain.entity.User;

public interface UserRepository {

    /**
     * 根据邮箱查询用户信息
     * @param email
     * @return
     */
    User selectUserByEmail(String email);

    /**
     * 注册用户
     * @param userDTO
     * @return
     */
    Integer register(UserDTO userDTO);

    /**
     * 登录
     * @param userDTO
     * @return
     */
    User login(UserDTO userDTO);

    /**
     * 更新用户所在的当前房间的ID
     * @param hourseId 房间id
     * @param userId 用户id
     * @return
     */
    Integer updateUserCurHourse(Long hourseId, Long userId);
}
