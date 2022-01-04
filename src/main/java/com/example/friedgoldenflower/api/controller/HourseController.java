package com.example.friedgoldenflower.api.controller;

import com.example.friedgoldenflower.api.dto.HourseDTO;
import com.example.friedgoldenflower.api.dto.Result;
import com.example.friedgoldenflower.app.service.HourseService;
import com.example.friedgoldenflower.common.utils.HourseCodeUtils;
import com.example.friedgoldenflower.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/hourse")
@Controller
public class HourseController {

    @Autowired
    private HourseService hourseService;

    /**
     * 创建房间
     * @return
     */
    @GetMapping("/createHourse")
    public String createHourse(HourseDTO hourseDTO, HttpServletRequest request){
        User cur = (User) request.getSession().getAttribute("loginUser");
        hourseService.createHourse(cur);
        return "hourse/hourse";
    }

    /**
     * 加入房间
     * @return
     */
    @GetMapping("/joinHourse")
    public String joinHourse(){

        return "hourse/hourse";
    }


}
