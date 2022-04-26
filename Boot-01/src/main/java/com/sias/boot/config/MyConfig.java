package com.sias.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * @author Edgar
 * @create 2022-02-26 17:19
 */
@Configuration
public class MyConfig /*implements WebMvcConfigurer*/ {

    //1.更改_method这个名字
    // （其实该不该都是无所谓的，更改的话，写的名字可能会变少，更改之后，在去写原先的名字也是可以的）
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter filter = new HiddenHttpMethodFilter();
        filter.setMethodParam("m");
        return filter;
    }

    /*2.开启矩阵变量的使用
    *   需要去继承一个类WebMvcConfigurer
    *   还有一种方式，个人理解比较难*/
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        UrlPathHelper urlPathHelper = new UrlPathHelper();
//        //不移除后面的内容，矩阵变量就会生效
//        urlPathHelper.setRemoveSemicolonContent(false);
//        configurer.setUrlPathHelper(urlPathHelper);
//    }


    /*2.另外一种方式开启矩阵变量*/
//    public WebMvcConfigurer webMvcConfigurer(){
//        return new WebMvcConfigurer() {
//            @Override
//            public void configurePathMatch(PathMatchConfigurer configurer) {
//                UrlPathHelper urlPathHelper = new UrlPathHelper();
//                //不移除后面的内容，矩阵变量就会生效
//                urlPathHelper.setRemoveSemicolonContent(false);
//                configurer.setUrlPathHelper(urlPathHelper);
//            }
//        };
//    }
}
