package com.zzy.service;

import com.zzy.dao.pojo.SysUser;

public interface SysUserService {
    SysUser findUserById(Long id);
}
