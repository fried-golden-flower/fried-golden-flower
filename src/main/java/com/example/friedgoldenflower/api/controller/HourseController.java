package com.example.friedgoldenflower.api.controller;

import com.example.friedgoldenflower.api.dto.HourseDTO;
import com.example.friedgoldenflower.api.dto.Result;
import com.example.friedgoldenflower.app.service.HourseService;
import com.example.friedgoldenflower.common.utils.HourseCodeUtils;
import com.example.friedgoldenflower.domain.entity.Hourse;
import com.example.friedgoldenflower.domain.entity.User;
import com.example.friedgoldenflower.domain.repository.HourseRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/hourse")
@Controller
public class HourseController {

    @Autowired
    private HourseService hourseService;
    @Autowired
    private HourseRespository hourseRespository;

    /**
     * 登录成功用户跳转到用户当前所在房间
     *
     * @return
     */
    @GetMapping
    public String hourse(HttpServletRequest request, Model model) {
        User cur = (User) request.getSession().getAttribute("loginUser");
        Hourse hourse = hourseRespository.selectHourseByUserId(cur.getId());
        Result result = new Result();
        result.setSuccess(true);
        result.setContent(hourse);
        result.setMsg("登录成功");
        model.addAttribute("result",result);
        return "hourse/hourse";
    }

    /**
     * 创建房间
     *
     * @return
     */
    @GetMapping("/createHourse")
    public String createHourse(HourseDTO hourseDTO, HttpServletRequest request, Model model) {
        User cur = (User) request.getSession().getAttribute("loginUser");
        Result result;
        try {
            result = hourseService.createHourse(cur);
        } catch (Exception e) {
            result = new Result();
            result.setSuccess(false);
            result.setContent(null);
            result.setMsg("创建房间异常");
        }
        model.addAttribute("result", result);
        if (result.getSuccess()) {
            return "hourse/hourse";
        } else {
            return "index";
        }
    }

    /**
     * 加入房间
     *
     * @return
     */
    @GetMapping("/joinHourse")
    public String joinHourse() {

        return "hourse/hourse";
    }


}
