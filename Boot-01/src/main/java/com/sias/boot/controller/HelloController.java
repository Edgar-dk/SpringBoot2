package com.sias.boot.controller;

import com.sias.boot.Bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Edgar
 * @create 2022-02-25 21:40
 */
/*
* 在类上的注解，相当于是Controller和ResponseBody
* 一个是控制器，一个是把放回的值，相应到浏览器页面上*/
@RestController
public class HelloController {
    /*1.*/
    @Autowired
    private Person person;
    @RequestMapping("/person")
    public Person TestPerson(){
        return person;
    }

    /*2.返回的说字符串，所以是String类型，Delete和Put的方式，需要在配置文件中去配置开启*/
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(){
        return "张三，你看到了我吗，是的看到了";
    }
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String saveUser(){
        return "Post-张三";
    }
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String putUser(){
        return "Put-张三";
    }
    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser(){
        return "Delete-张三";
    }


    /*
    * 3.在控制器中，写的只是一个接受数据的模板，真正要数据的
    *   还是在实图部分传递真实的数据，在注解部分写的是一个模板，前面名字，后面数据的名字（还没有填写真实数据）
    *   把数据的名字填写在参数中，用作接受，以简直对的方式接受，在接受数据的时候，需要写括号*/
    @GetMapping("/car/{Id}/owner/{username}" )
    public Map<String,Object> getCCar(@PathVariable("Id") Integer id,
                                      @PathVariable("username") String name,
                                      @PathVariable Map<String,String> pv,
                                      /*01.获取请求头信息的注解,括号中的是按照获取的名字来的*/
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String,String> header,
                                      /*02.在实图层，写数，传递到控制层，就是在一个地址栏中添加数据
                                       * 然后用特定的参数去接受*/
                                      @RequestParam("age") Integer age,
                                      @RequestParam("inters")List<String> inters
//                                      @CookieValue("_ga") String ga
                                      ){
        Map<String,Object> map=new HashMap<>();
//        map.put("Id",id);
//        map.put("username",name);
//        map.put("pv",pv);
//        /*01.解释：从浏览器获得的请求头信息，放在了String类型的userAgent中
//        * 获取之后，然后放在map中，最后在把map返回到浏览器的页面上，双引
//        * 号前面的是名字，会打印到浏览器上，后面的才是内容*/
//        map.put("userAgents",userAgent);
//        map.put("headers",header);
        /*02.在地址栏中写名字数据传递过来，在打印到浏览器的页面*/
//        map.put("age",age)
        map.put("age1",age);
        map.put("inters1",inters);
//        map.put("_ga",ga);
        return map;
    }




    /*4.练习RequestBody，用post的方式传递*/
//    @PostMapping("/save")
//    public Map RequestBody(@RequestBody String content){
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("content",content);
//        return map;
//    }


}
