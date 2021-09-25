package com.zzy.controller;

import com.alibaba.fastjson.JSON;
import com.zzy.dao.pojo.SysUser;
import com.zzy.service.LoginService;
import com.zzy.service.SysUserService;
import com.zzy.utils.JWTUtils;
import com.zzy.vo.ErrorCode;
import com.zzy.vo.Result;
import com.zzy.vo.params.LoginParam;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.TimeoutUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.concurrent.TimeUnit;

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