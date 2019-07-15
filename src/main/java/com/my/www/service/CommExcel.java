package com.my.www.service;

import javax.servlet.ServletOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @Classname CommExcel
 * @Description TODO
 * @Date 2019/7/1 8:11
 * @Created by Eaven
 */
public interface CommExcel {
    boolean importExcel(Object obj, File myFile, String myFileContentType) throws Exception;

    boolean exportExcel(Object obj, FileInputStream fileInputStream, ServletOutputStream outputStream) throws Exception;

    void getObjClass(Object object) throws Exception;
}
