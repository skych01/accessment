package com.hhxk.assessment.web;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping(value = "/login")
    public String login(Model model, Authentication authentication) {
        return "pages/login";
    }
    @RequestMapping(value = "/")
    public String defaultPath(Model model, Authentication authentication) {
        return "pages/login";
    }

    @RequestMapping(value = "/index")
    public String index(Model model, Authentication authentication) {
        return "pages/index";
    }

    @RequestMapping(value = "/object")
    public String object(Model model, Authentication authentication) {
        return "pages/object";
    }

    @RequestMapping(value = "/addObject")
    public String addObject(Model model, Authentication authentication) {
        return "pages/addObject";
    }

    @RequestMapping(value = "/type")
    public String type(Model model, Authentication authentication) {
        return "pages/type";
    }

    @RequestMapping(value = "/metting")
    public String metting(Model model, Authentication authentication) {
        return "pages/metting";
    }

    @RequestMapping(value = "/mettingObject")
    public String mettingObject(Model model, Authentication authentication) {
        return "pages/mettingObject";
    }

    @RequestMapping(value = "/addMetting")
    public String addMetting(Model model, Authentication authentication) {
        return "pages/addMetting";
    }
}
