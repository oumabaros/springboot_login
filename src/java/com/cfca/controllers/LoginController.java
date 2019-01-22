/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cfca.controllers;


import com.cfca.security.IChangePassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ouma
 */
@Controller
public class LoginController {
    @Autowired
    private IChangePassword changePasswordDao;
    //@Autowired
    //private UserDetailsManager userDetailsManager;
    
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String login(){
        return "login";
    }
    
    @RequestMapping(value="/home",method=RequestMethod.GET)
    public String home(){
        return "home";
    }
    
    @RequestMapping(value="/account/changePassword",method=RequestMethod.GET)
    public String changePwd(){
        return "account/changePassword";
    }
    
    @RequestMapping(value="/account/changePassword",method=RequestMethod.POST)
    public String submitChangePasswordPage(@RequestParam("password")String newPassword) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.toString();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        }
        
        changePasswordDao.changePassword(username, newPassword);
        SecurityContextHolder.clearContext();
        return "redirect:/home.htm";
        
    }
    /*
    @RequestMapping(value="/account/changePassword",method=RequestMethod.POST)
    public String submitChangePasswordPage(@RequestParam("oldpassword")String oldPassword,@RequestParam("password")String newPassword) {
        userDetailsManager.changePassword(oldPassword, newPassword);
        SecurityContextHolder.clearContext();
        return "redirect:/home.htm";

    }
    */
}
