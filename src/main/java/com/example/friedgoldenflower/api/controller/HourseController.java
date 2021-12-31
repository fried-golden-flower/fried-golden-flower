package com.example.friedgoldenflower.api.controller;

import com.example.friedgoldenflower.api.dto.Result;
import com.example.friedgoldenflower.app.service.HourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String createHourse(){
        hourseService.createHourse();
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
