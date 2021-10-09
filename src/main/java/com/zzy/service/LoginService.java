package com.zzy.service;

import com.zzy.dao.pojo.SysUser;
import com.zzy.vo.Result;
import com.zzy.vo.params.LoginParam;

public interface LoginService {
    Result login(LoginParam loginParam);

    SysUser checkToken(String token);

    Result logout(String token);

    Result register(LoginParam loginParam);
}
