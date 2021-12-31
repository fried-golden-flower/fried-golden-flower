package com.example.friedgoldenflower.api.controller;

import com.example.friedgoldenflower.api.dto.Result;
import com.example.friedgoldenflower.api.dto.UserDTO;
import com.example.friedgoldenflower.app.service.UserService;
import com.example.friedgoldenflower.domain.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 发送邮箱验证码
     * @param userDTO
     * @return
     */
    @PostMapping("/sendEmailCode")
    @ResponseBody
    public Result sendEmailCode(@RequestBody UserDTO userDTO) {
        LOGGER.info("sendEmailCode..." + userDTO);
        Result result = userService.sendEmailCode(userDTO);
        return result;
    }

    /**
     * 校验验证码
     * @param userDTO
     * @return
     */
    @PostMapping("/checkRegister")
    @ResponseBody
    public Result checkRegister(@RequestBody UserDTO userDTO) {
        LOGGER.info("checkRegister..." + userDTO);
        return userService.checkRegister(userDTO);
    }

    /**
     * 登录
     * @param userDTO
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO, Model model) {
        LOGGER.info("login..." + userDTO);
        Result result = userService.login(userDTO);
        model.addAttribute("result",result);
        if(result.getSuccess()){
            User user = (User) result.getContent();
            if(!Objects.isNull(user.getCurHourse())){
                return "hourse/hourse";
            }else{
                return "index";
            }
        }else{
            return "login";
        }
    }

    /**
     * 注册
     * @param userDTO
     * @return
     */
    @PostMapping("/register")
    //@RequestBody提交表单不能加，默认的content-type为：application/x-www-form-urlencoded
    public String register(UserDTO userDTO, Model model) {
        LOGGER.info("register..." + userDTO);
        Result result = userService.register(userDTO);
        LOGGER.info(result.toString());
        if(result.getSuccess()){
            return "login";
        }else{
            model.addAttribute("result",result);
            return "register";
        }
    }
}
