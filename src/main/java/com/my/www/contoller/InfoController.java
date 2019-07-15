package com.my.www.contoller;

import com.my.www.dao.mapper.UserMapper;
import com.my.www.dao.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;

/**
 * @Classname InfoController
 * @Description TODO
 * @Date 2019/6/27 8:42
 * @Created by Eaven
 */
@RestController
@RequestMapping("info")
public class InfoController {
    @Resource
    private UserMapper userMapper;

    @RequestMapping("showIndex")
    public ModelAndView showIndex() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @RequestMapping("login")
    public ModelAndView login() {
        System.out.println("login");
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user.getName());
        ModelAndView mv = new ModelAndView("pages/login");
        return mv;
    }

}
