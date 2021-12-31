package com.example.friedgoldenflower.infra.repository.impl;

import com.example.friedgoldenflower.domain.entity.RegisterCode;
import com.example.friedgoldenflower.domain.repository.RegisterCodeRepository;
import com.example.friedgoldenflower.infra.mapper.RegisterCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterCodeRepositoryImpl implements RegisterCodeRepository {

    @Autowired
    private RegisterCodeMapper registerCodeMapper;

    @Override
    public Integer save(RegisterCode registerCode) {
        return registerCodeMapper.save(registerCode);
    }

    @Override
    public RegisterCode selectRegisterCodeByEmail(String email) {
        return registerCodeMapper.selectRegisterCodeByEmail(email);
    }

    @Override
    public void deleteRegisterCodeByEmail(String email) {
        registerCodeMapper.deleteRegisterCodeByEmail(email);
    }
}
