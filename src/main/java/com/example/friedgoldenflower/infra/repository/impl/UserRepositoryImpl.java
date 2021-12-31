package com.example.friedgoldenflower.infra.repository.impl;

import com.example.friedgoldenflower.api.dto.UserDTO;
import com.example.friedgoldenflower.domain.entity.User;
import com.example.friedgoldenflower.domain.repository.UserRepository;
import com.example.friedgoldenflower.infra.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByEmail(String email) {
        if(ObjectUtils.isEmpty(email)){
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        return userMapper.selectUser(userDTO);
    }

    @Override
    public Integer register(UserDTO userDTO) {
        return userMapper.insertUser(userDTO);
    }

    @Override
    public User login(UserDTO userDTO) {
        return userMapper.login(userDTO);
    }
}
