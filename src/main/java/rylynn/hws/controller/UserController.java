package rylynn.hws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rylynn.hws.entity.User;
import rylynn.hws.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/registerUser.do")
    public void registerUser(@RequestParam String name , @RequestParam String password , @RequestParam String homenum , @RequestParam String grade)
    {
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
        User user = new User(name ,password ,Integer.parseInt(homenum) ,gradenum);

        userService.registerUser(user);
    }
}
