package com.zzy.service;

import com.zzy.dao.pojo.SysUser;
import com.zzy.vo.Result;

public interface SysUserService {

    SysUser findUser(String account, String password);

    SysUser findUserById(Long id);

    Result findUserByToken(String token);

    SysUser findUserByAccount(String account);

    void save(SysUser sysUser);
}
