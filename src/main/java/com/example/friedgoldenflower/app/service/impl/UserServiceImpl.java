package com.example.friedgoldenflower.app.service.impl;

import com.example.friedgoldenflower.api.dto.Result;
import com.example.friedgoldenflower.api.dto.UserDTO;
import com.example.friedgoldenflower.app.service.RegisterCodeService;
import com.example.friedgoldenflower.app.service.UserService;
import com.example.friedgoldenflower.domain.entity.RegisterCode;
import com.example.friedgoldenflower.domain.entity.User;
import com.example.friedgoldenflower.domain.repository.RegisterCodeRepository;
import com.example.friedgoldenflower.domain.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Value("${spring.mail.username}")
    private String serverMail;

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private RegisterCodeRepository registerCodeRepository;
    @Autowired
    private RegisterCodeService registerCodeService;
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result sendEmailCode(UserDTO userDTO) {
        Result result = new Result();
        if(Objects.isNull(userDTO.getEmail())){
            result.setSuccess(false);
            result.setContent("邮箱不能为空");
            return result;
        }
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setFrom(serverMail);
            helper.setTo(userDTO.getEmail());
            helper.setSubject("体验游戏账号-注册"); //主题
            String code = Long.toString(System.currentTimeMillis()%1000000);
            helper.setText("你好 "+userDTO.getUserName()+":<br/>体验游戏账号注册码为：<b>"+code+"");    //内容
            mailSender.send(helper.getMimeMessage());//发生邮件
            LOGGER.info("\n"+serverMail+":发送邮件至:"+userDTO.getEmail()+"\n主题:"+"体验游戏账号-注册"+"\n内容:"+"");
            registerCodeRepository.deleteRegisterCodeByEmail(userDTO.getEmail());
            RegisterCode registerCode = new RegisterCode();
            registerCode.setCode(code);
            registerCode.setCreateTime(new Date());
            registerCode.setEmail(userDTO.getEmail());
            registerCodeRepository.save(registerCode);
            result.setSuccess(true);
            result.setContent("邮件发送成功");
            return result;
        } catch (Exception e) {
            LOGGER.error("邮件格式错误:"+e.getMessage());
            e.printStackTrace();
            result.setSuccess(false);
            result.setContent("邮件发送错误");
            return result;
        }
    }

    @Override
    public Result checkRegister(UserDTO userDTO) {
        Result result = new Result();
        User user = userRepository.selectUserByEmail(userDTO.getEmail());
        if (!ObjectUtils.isEmpty(user)){
            result.setSuccess(false);
            result.setContent("该邮箱已注册");
            return result;
        }
        //校验邮箱验证码
        result = registerCodeService.checkRegisterCode(userDTO);
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result register(UserDTO userDTO) {
        //校验
        Result result = checkRegister(userDTO);
        if(!result.getSuccess()){
            return result;
        }
        try {
            Integer user = userRepository.register(userDTO);
            LOGGER.info(user.toString());
            result.setSuccess(true);
            result.setContent("注册成功");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setContent(e.getMessage());
            return result;
        }
    }

    @Override
    public Result login(UserDTO userDTO) {
        Result result = new Result();
        if(ObjectUtils.isEmpty(userDTO.getUserName())){
            result.setSuccess(false);
            result.setContent("用户名不能为空");
            return result;
        }
        if(ObjectUtils.isEmpty(userDTO.getPassword())){
            result.setSuccess(false);
            result.setContent("密码不能为空");
            return result;
        }
        User user = userRepository.login(userDTO);
        result.setSuccess(true);
        result.setContent(user);
        return result;
    }

}
