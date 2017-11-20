package rylynn.hws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import rylynn.hws.entity.User;
import rylynn.hws.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/registerUser.do" ,method = RequestMethod.POST)
    public ModelAndView registerUser(@RequestParam("name") String name , @RequestParam("account") String account , @RequestParam("password") String password , @RequestParam("homenum") int homenum , @RequestParam("grade") String grade)
    {
        ModelAndView mav = new ModelAndView("result");
        int gradenum = 0;
        if(grade.equals("大一"))
        {
            gradenum = 1;
        }
        else if(grade.equals("大二"))
        {
            gradenum = 2;
        }
        else if(grade.equals("大三"))
        {
            gradenum = 3;
        }
        User user = new User(name ,account ,password ,homenum ,null ,gradenum);

        if(userService.registerUser(user) == 0)
        {
            mav.addObject("result" ,"用户已存在");
        }
        else
        {
            mav.addObject("result" ,"注册成功！");
        }
        return mav;
    }
}
