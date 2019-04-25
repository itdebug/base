package com.example.base.bean;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lrk
 * @date 2019/4/24下午9:35
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {
        ClassLoader myLoader = new ClassLoader() {
            @Override public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";

                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }

                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return super.loadClass(name);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object object = myLoader.loadClass("com.example.base.bean.ClassLoaderTest").newInstance();

        System.out.println(object.getClass());
        System.out.println(object instanceof com.example.base.bean.ClassLoaderTest);
    }
}
