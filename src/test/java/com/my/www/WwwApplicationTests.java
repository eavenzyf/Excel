package com.my.www;

import com.my.www.dao.pojo.User;
import com.my.www.service.CommExcel;
import com.my.www.service.impl.CommExcelImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WwwApplication.class)
public class WwwApplicationTests {
    CommExcel commExcel = new CommExcelImpl();

    @Test
    public void contextLoads() {
    }

    @Test
    public void showMethod() {
        User user = new User();
        File file = new File("");
        try {
            commExcel.importExcel(user, file, "name");

        } catch (Exception e) {
            System.out.println("error");
        }
        return;
    }

    @Test
    public void showMy() throws Exception {
        User user = new User();
        commExcel.getObjClass(user);
    }
}
