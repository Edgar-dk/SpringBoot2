package com.sias.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Edgar
 * @create 2022-02-28 18:16
 */

/**/
@Controller
public class RequestBody {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        /*01.原始的方式设置数据（在作用域中），在参数的地方，把这个对象去创建，然后在去调用
        *    里面的方法去设置数据*/
        request.setAttribute("msg","这是成功的标志。。。。");
        /*02.实现页面的跳转（页面的转发）*/
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute("msg") String msg,//03.注解的方式去获取数据
                          HttpServletRequest request){
        /*04.原始的方式去接受数据（既然是Request的方式，同时也是需要Request的方式去接受）
        *     需要在参数的地方去写这个对象，然后在用这个对象里面的方法去获取*/
        Object msg1 = request.getAttribute("msg");
        Map<String,Object> map=new HashMap<>();
        map.put("Annotation",msg1);
        map.put("RequstMethod", msg);//注解的方式获取数据，只需要把msg写上，前面的是名字
        return map;
    }
}
