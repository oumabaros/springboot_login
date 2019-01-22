/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cfca.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

/**
 *
 * @author ouma
 */
public class CustomJdbcDaoImpl extends JdbcDaoImpl implements IChangePassword {
    @Autowired
    private PasswordEncoder passwordEncoder;
    //@Autowired
    //private SaltSource saltSource;
    
    public void changePassword(String username, String password) {
        UserDetails user = loadUserByUsername(username);
        //String encodedPassword = passwordEncoder.encodePassword(password,null);
        getJdbcTemplate().update("UPDATE users SET password =sha1(?) WHERE username = ?",password, username);
    }
}
