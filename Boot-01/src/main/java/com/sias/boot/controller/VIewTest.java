package com.sias.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Edgar
 * @create 2022-03-01 18:22
 */
@Controller
public class VIewTest {

    @RequestMapping("/atguigu")
    public String viewTest(Model model){
        model.addAttribute("Sias","你好这是sias");
        model.addAttribute("Link1111111","http://www.baidu.com");
        return "success";
    }
}
