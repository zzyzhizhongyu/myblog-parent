package com.zzy.controller;

import com.zzy.service.LoginService;
import com.zzy.vo.Result;
import com.zzy.vo.params.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("login")
public class LoginController {


    @Autowired
    private LoginService loginService;
    @PostMapping
    public Result login(@RequestBody LoginParam loginParam){

        return loginService.login(loginParam);
    }


}