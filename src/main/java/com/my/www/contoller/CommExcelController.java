package com.my.www.contoller;

import com.my.www.dao.mapper.UserMapper;
import com.my.www.dao.pojo.Message;
import com.my.www.dao.pojo.User;
import com.my.www.utils.ExcelUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname CommExcelController
 * @Description TODO
 * @Date 2019/7/1 8:41
 * @Created by Eaven
 */
@RestController
@RequestMapping("excel")
public class CommExcelController {
    @Resource
    private UserMapper userMapper;

    @RequestMapping("import")
    public Message importExcel() {
        Message msg = new Message();
        try {
            InputStream in = new FileInputStream("d://cc.xls");
            Map<String, String> fieldd = new HashMap<String, String>();
            //从Excel表到数据库 key为Excel表头，value为数据库字段名
            fieldd.put("id", "id");
            fieldd.put("用户名", "username");
            fieldd.put("密码", "password");
            fieldd.put("姓名", "name");
            fieldd.put("年龄", "age");
            List<User> resultList = new ArrayList<User>();
            resultList = ExcelUtil.ExecltoList(in, User.class, fieldd);
            for (User user : resultList) {
                User userIn = new User();
                userIn.setId(user.getId());
                userIn.setAge(user.getAge());
                String name = user.getName();
                System.out.println("name:"+name);
                userIn.setName(name);
                userIn.setPassword(user.getPassword());
                userIn.setUsername(user.getUsername());
                System.out.println("打印导入的用户名：");
                System.out.println(user.getName());
                //将包装好数据的user 插入到数据表中
                userMapper.insert(userIn);
            }
            msg.setMsg("导入成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("得到的异常：" + e.getMessage());
            msg.setMsg(e.getMessage());
        }
        return msg;
    }

    @RequestMapping("export")
    public Message exportExcel() throws Exception {
        Message msg = new Message();
        try {
            //导出前 确认所要导出的盘符没有和导出文件重名的文件
            List<User> userList = userMapper.selectAll();
            List<User> li = new ArrayList<User>();
            for (User user : userList) {
                //将查出的数据装载到ArrayList里
                li.add(user);
            }
            OutputStream out = new FileOutputStream("d://aa.xls");
            Map<String, String> fields = new HashMap<String, String>();
            //从数据库到Excel表 key为数据库字段 value为Excel表头
            fields.put("id", "id");
            fields.put("username", "用户名");
            fields.put("password", "密码");
            fields.put("name", "姓名");
            fields.put("age", "年龄");
            ExcelUtil.ListtoExecl(li, out, fields);
            out.close();
            msg.setMsg("导出成功！");
        } catch (Exception e) {
            msg.setMsg("导出失败！");
        }
        return msg;
    }
}
