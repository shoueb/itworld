package com.shoueb.itworld;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.math.BigDecimal;

/**
 * @Description: 程序启动入库
 * @Author: yuangui.hu
 * @Date: 2018-09-03
 */
@SpringBootApplication
@MapperScan("com.shoueb.itworld.*.mapper")
@ServletComponentScan
public class ItworldApplication {
    /**
     * 程序启动入库
     * @param args main参数组
     */
    public static void main(String[] args) {
        //Spring Boot + Mybatis +th模板 +Mymapper【tk】+分页插件
        SpringApplication.run(ItworldApplication.class, args);

       /* BigDecimal goodsNum=new BigDecimal("0");
        if(new BigDecimal(goodsNum.intValue()).compareTo(goodsNum)!=0 || goodsNum.compareTo(BigDecimal.ZERO)<0){
            System.out.println("goodsNum: 货物数量不能带有小数或小于等于0");
        }*/
    }

}

