package com.my.www.contoller;
import com.my.www.dao.mapper.UserMapper;
import com.my.www.dao.pojo.Message;
import com.my.www.dao.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Classname LoginContoller
 * @Description TODO
 * @Date 2019/6/27 9:56
 * @Created by Eaven
 */
@RestController
@RequestMapping("login")
public class LoginContoller {

    @Resource
    private UserMapper userMapper;
    @RequestMapping("checkLogin")
    public Message checkLogin(String username, String password, String code,
                              HttpServletRequest request,
                              HttpSession session) {
        Message msg = new Message();
        System.out.println("==================");
        System.out.println("用户名："+username);
        System.out.println("密码："+password);
        User user = userMapper.selectByUserName(username);
        if (user == null) {
            msg.setCode(400);
            msg.setMsg("用户名或者密码错误！");
        } else {
            session.setAttribute("user", user);
            msg.setCode(200);
            msg.setMsg("登陆成功！");
        }
        return msg;
    }

    //跳转到首页
    @RequestMapping("main")
    public ModelAndView showMain() {
        ModelAndView mv = new ModelAndView("pages/main");
        return mv;
    }
}
