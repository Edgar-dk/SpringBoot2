package com.sias.boot.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Edgar
 * @create 2022-03-01 15:57
 */
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Person1 {
    private String userName;
    private Integer age;
    private Date birth;
    private Pet1 pet1;
}
