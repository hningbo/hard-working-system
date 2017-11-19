package rylynn.hws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class RegisterController {

    @RequestMapping("/")
    public ModelAndView index()
    {
        ModelAndView mav = new ModelAndView("/");
        mav.addObject("user" ,null);
        return mav;
    }
    @RequestMapping("/study.do")
    public ModelAndView regesterOverTime()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("result");
        Date date = new Date();
        int hour = date.getHours();
        int min = date.getMinutes();
        if(hour >= 22 && min >= 20)
        {
            mav.addObject("result" ,"不在加班时间范围内！");
        }
        else
        {
            mav.addObject("result" ,"成功上报加班，提高效率，早点休息！");
        }
        return mav;
    }

    @RequestMapping("/giveup.do")
    public ModelAndView giveupOverTime()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("result");
        Date date = new Date();
        int hour = date.getHours();
        int min = date.getMinutes();
        if(hour >= 22 && min >= 20)
        {
            mav.addObject("result" ,"不在退报加班时间范围内！");
        }
        else
        {
            mav.addObject("result" ,"成功退报加班！");
        }
        return mav;
    }


}
