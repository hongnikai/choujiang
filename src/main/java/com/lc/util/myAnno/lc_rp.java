package com.lc.util.myAnno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *  @描述：注解练习
 *    description：封装注解
 ** @author LC
 *  创建时间：2018-8-12 下午23:30
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface lc_rp {

//    用@Retention(RetentionPolicy.CLASS)修饰的注解，表示注解的信息被保留在class文件(字节码文件)中当程序编译时，但不会被虚拟机读取在运行的时候；
//    用@Retention(RetentionPolicy.SOURCE )修饰的注解,表示注解的信息会被编译器抛弃，不会留在class文件中，注解的信息只会留在源文件中；
//    用@Retention(RetentionPolicy.RUNTIME )修饰的注解，表示注解的信息被保留在class文件(字节码文件)中当程序编译时，会被虚拟机保留在运行时，


    String value() default "0";             //定义默认值 value

    String defaulVaule() default "无";       //定义默认值

    Boolean req = null;                      //定义输入参数的值

    String[] str() default  {"1","2","3"};   //定义一个数组

    int[] inner() default {1,2,3};           //定义一个整型数组



}
