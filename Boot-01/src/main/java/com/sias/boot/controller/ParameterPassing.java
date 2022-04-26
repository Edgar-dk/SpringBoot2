package com.sias.boot.controller;

import com.sias.boot.Bean.Person1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Edgar
 * @create 2022-02-28 19:49
 */
@RestController
public class ParameterPassing {


    @RequestMapping("/tun")
    public String tun(){
        return "tun";
    }

    /*1.原始的方式传递参数*/
//    @ResponseBody
    @RequestMapping("/RequestParam")
    public Map RequestParam(@RequestParam("age") Integer age,
                            @RequestParam("inters") String inters
                              ){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("age1",age);
        map.put("inters1",inters);
        return map;
    }

    /*2..矩阵的方式传递参数
    *    需要去Myconfig中去开启矩阵变量*/
    @GetMapping("/car/{path}")
    public Map MatrixVariable(@MatrixVariable("low") Integer low,
                              @MatrixVariable("brand") List<String> brand,
                              @PathVariable("path") String path){
        Map<String, Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path111111111111",path);
        return map;
    }
    /*02.不同的方式的矩阵变量*/
    @RequestMapping("/car/{bossId}/{empId}")
    public Map MatrixVariable2(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                               @MatrixVariable(value = "age",pathVar = "empId") Integer emAge){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("emAge1",emAge);
        map.put("bossId11",bossAge);
        return map;
    }

    /*3.作用域中共享数据*/
    @GetMapping("/param")
    public String TestParam(Map<String,Object> map,//这是在参数中new，是可以直接在方法中去使用的
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response){
        map.put("这是map的方式去调用","map66666");
        model.addAttribute("这是model的方式去调用的","model6666");
        request.setAttribute("这是request的方式去调用的","request66666");
        Cookie cookie = new Cookie("这是cookie的方式","cookie666");
        cookie.setDomain("localhost");
        response.addCookie(cookie);
        return "redirect:/success";
    }


    /*4.处理写好的数据请求*/
    @ResponseBody
    @PostMapping("/saver")
    public Person1 saveuser(Person1 person1){
        return person1;
    }
}
