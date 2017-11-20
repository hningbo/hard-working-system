package rylynn.hws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import rylynn.hws.entity.User;
import rylynn.hws.service.UserService;
import rylynn.hws.service.impl.UserServiceImpl;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping("/admin.do")
    public ModelAndView showAllOvertime()
    {
        ModelAndView mav = new ModelAndView("index");
        List<User> overtimeUser = userService.findOvertimeUser();

        /*
        sort the user according to the unit firstly 1qvdui first,and than 2qvdui 3qvdui
        and than according to the homenum sort the user which also basicall sort the grade
         */
        Collections.sort(overtimeUser, new Comparator<User>() {
            public int compare(User o1, User o2) {
                if(o1.getUnit() < o2.getUnit())
                {
                    return -1;
                }
                else if(o1.getUnit() == o2.getUnit())
                {
                    if(o1.getGrade() < o2.getGrade())
                    {
                        return -1;
                    }
                    else if(o1.getGrade() == o2.getGrade()) {
                        if (o1.getHomenum() < o2.getHomenum()) {
                            return -1;
                        } else {
                            return 1;
                        }
                    }
                    else
                    {
                        return 1;
                    }
                }
                else
                {
                    return 1;
                }

            }
        });
        mav.addObject("user" ,overtimeUser);
        return mav;
    }
}
