package com.ycs.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ycs.entity.User;
import com.ycs.mapper.UserMapper;

@CrossOrigin
@Controller
@RequestMapping(value = "/user")
public class UserController {
    
    @Resource
    private UserMapper userDao;

    @RequestMapping("/view")
    public String view() {
        return "login";
    }
    
    @RequestMapping("/indexview")
    public String index() {
        return "index";
    }
    
    /*@RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(User model, HttpSession session) {
        User user = userDao.findByUsername(model.getUsername());

        if (user == null || !user.getPassword().equals(model.getPassword())) {
            return new ModelAndView("redirect:view.action");
        } else {
            session.setAttribute("user", user);
            ModelAndView mav = new ModelAndView();
            mav.setViewName("index");
            return mav;
        }
    }*/
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public User login(User model, HttpSession session) {
    	User user = userDao.findByUsername(model.getUsername());
        if (user == null || !user.getPassword().equals(model.getPassword())) {
            return null;
        } else {
            session.setAttribute("user", user);
            
            return user;
        }
    }
    
}
