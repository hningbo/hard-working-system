package rylynn.hws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import rylynn.hws.service.UserService;
import rylynn.hws.service.impl.UserServiceImpl;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping("/admin.do")
    public ModelAndView showAllOvertime()
    {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("user" ,userService.findOvertimeUser());
        return mav;
    }
}
