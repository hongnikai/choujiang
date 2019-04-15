package com.lc.test;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Map;

@Component
public class TaskTest {
    public final Logger log = Logger.getLogger(this.getClass());

    public void run() {
        for (int i = 0; i < 1; i++) {
            log.debug(i + " run......................................" + (new Date()));
        }

    }

    public void run1() {
        for (int i = 0; i < 1; i++) {
            log.debug(i + " run1......................................" + (new Date()));
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {


        ClassLoader classLoader =TaskTest.class.getClassLoader();
        Class<?> loadClass = classLoader.loadClass("com.lc.tesseract_OCR.Tesseract_tess4j");
        Method method = loadClass.getMethod("main", String[].class);
        method.invoke(null, new Object[] { new String[] {} });


//
//        String c = null;
//        Map<String, Charset> charsets = Charset.availableCharsets();
//        for (Map.Entry<String, Charset> entry : charsets.entrySet()) {
//            System.out.println(entry.getKey());
//        }

    }

}
