package com.example.friedgoldenflower.domain.repository;

import com.example.friedgoldenflower.domain.entity.RegisterCode;

public interface RegisterCodeRepository {

    /**
     * 保存验证码到数据库,创建时间为当前时间
     * @param registerCode
     */
    Integer save(RegisterCode registerCode);

    /**
     * 根据邮箱查询验证码
     * @param email
     * @return
     */
    RegisterCode selectRegisterCodeByEmail(String email);

    /**
     * 根据邮箱删错验证码
     * @param email
     */
    void deleteRegisterCodeByEmail(String email);
}
