package com.my.www.service.impl;

import com.my.www.service.CommExcel;

import javax.servlet.ServletOutputStream;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Classname CommExcelImpl
 * @Description TODO
 * @Date 2019/7/1 8:19
 * @Created by Eaven
 */
public class CommExcelImpl implements CommExcel {

    @Override
    public boolean importExcel(Object obj, File myFile, String myFileContentType) throws Exception {
        Class<?> clazz = obj.getClass();
        //获得所有的属性
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
            Method method = pd.getReadMethod();
            System.out.println(method);
        }
        return false;
    }

    @Override
    public boolean exportExcel(Object obj, FileInputStream fileInputStream, ServletOutputStream outputStream) throws Exception {
        return false;
    }

    @Override
    public void getObjClass(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        int i = 1;
        for (Field field : fields) {
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
//            Method method = pd.getReadMethod();
            Method method = pd.getWriteMethod();
            field.setAccessible(true);
            if (i == 1) {
                method.invoke(object, 18);
                System.out.println(object.toString());
            }
            System.out.println(method.toString());
            System.out.println("=============");
            System.out.println(i++);
        }
    }
}
