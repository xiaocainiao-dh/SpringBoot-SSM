package com.xiaocainiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String toIndex(ModelMap model){
        System.err.println("请求index界面");
        return "index";
    }


}
