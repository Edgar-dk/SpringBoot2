package com.sias.boot.controller;

import com.sias.boot.Bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author Edgar
 * @create 2022-03-01 17:28
 */
@Controller
public class ResponsePage {

    /*1.通过Json的方式放回数据
    *   器是在SpringBoot的底层已经写Json,直接使用即可*/
    @ResponseBody
    @GetMapping("/test/person")
    public Person gerPerson(){
        Person person = new Person();
        person.setAge(12);
        person.setBirth(new Date());
        person.setUserName("张三");
        return person;
    }
}
