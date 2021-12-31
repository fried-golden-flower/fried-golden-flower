package com.example.friedgoldenflower.infra.mapper;

import com.example.friedgoldenflower.domain.entity.RegisterCode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterCodeMapper {

    /**
     * 保存验证码
     * @param registerCode
     */
    Integer save(RegisterCode registerCode);

    /**
     * 根据邮箱查询验证码
     * @param email
     * @return
     */
    RegisterCode selectRegisterCodeByEmail(String email);

    void deleteRegisterCodeByEmail(String email);
}
