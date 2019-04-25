package com.example.base.bean;

/**
 * @author lrk
 * @date 2019/4/23下午9:16
 */
public class ConstantClass {

    static {
        System.out.println("ConstantClass init!");
    }

    public static final String HELLOWORLD = "hello world";

}
