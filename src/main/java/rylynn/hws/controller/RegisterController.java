package rylynn.hws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import rylynn.hws.service.UserService;

import java.util.Date;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("user", null);
        return mav;
    }

    @RequestMapping(value = "/study.do" ,method = RequestMethod.POST ,produces="text/html; charset=UTF-8")
    public ModelAndView regesterOverTime(@RequestParam("account") String account, @RequestParam("password")String password, @RequestParam("place") String place) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("result");
        Date date = new Date();
        int hour = date.getHours();
        int min = date.getMinutes();
        if (hour >= 22 && min >= 20) {
            mav.addObject("result", "不在加班时间范围内！");
        } else {
            if (userService.userExist(account) == 0) {
                mav.addObject("result", "用户不存在！");
            } else {
                if (userService.checkPassword(account, password) == 1) {
                    userService.registerOvertime(account, place);
                    mav.addObject("result", "成功上报加班，提高效率，早点休息！");
                } else {
                    mav.addObject("result", "密码错误！");
                }

            }
        }
        return mav;
    }

    @RequestMapping(value="/giveup.do",method = RequestMethod.POST,produces="text/html; charset=UTF-8")
    public ModelAndView giveupOverTime(@RequestParam("account") String account, @RequestParam("password") String password, @RequestParam("place") String place) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("result");
        Date date = new Date();
        int hour = date.getHours();
        int min = date.getMinutes();
        if (hour >= 22 && min >= 20) {
            mav.addObject("result", "不在退报加班时间范围内！");
        } else {
            if (userService.userExist(account) == 0) {
                mav.addObject("result", "用户不存在！");
            } else {
                if (userService.checkPassword(account, password) == 1) {
                    userService.giveupOvertime(account);
                    mav.addObject("result", "成功退报加班！");
                } else {
                    mav.addObject("result", "密码不正确！");
                }

            }
        }

        return mav;
    }


}
