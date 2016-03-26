package com.wechat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 主页
 * Created by fusj on 15/12/25.
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     * 主页
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView home() {
        return new ModelAndView("html/home");
    }
}
