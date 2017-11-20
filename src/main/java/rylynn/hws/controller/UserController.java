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

    @RequestMapping(value = "/registerUser.do" ,method = RequestMethod.POST,produces="text/html; charset=UTF-8")
    public ModelAndView registerUser(@RequestParam("name") String name , @RequestParam("account") String account , @RequestParam("password") String password ,
                                     @RequestParam("unit")String unit ,@RequestParam("homenum") int homenum , @RequestParam("grade") String grade)
    {
        ModelAndView mav = new ModelAndView("result");

        int unitnum = Integer.parseInt(unit);
        int gradenum = Integer.parseInt(grade);
        User user = new User(name ,account ,password ,unitnum ,homenum ,"",gradenum);

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
