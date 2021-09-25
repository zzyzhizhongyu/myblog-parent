package com.zzy.service.impl;

import com.zzy.dao.mapper.SysUserMapper;
import com.zzy.dao.pojo.SysUser;
import com.zzy.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private LoginService loginService;

    @Override
    public SysUser findUser(String account, String password) {
        LambdaQueryWrapper<SysUser> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getAccount,account)
                    .eq(SysUser::getPassword,password)
                    .select(SysUser::getAccount,SysUser::getId,SysUser::getAvatar,SysUser::getNickname)
                    .last("limit 1");
        return sysUserMapper.selectOne(queryWrapper);
    }

    @Override
    public SysUser findUserById(Long id) {
        SysUser sysUser = sysUserMapper.selectById(id);
        if(sysUser==null){
            sysUser = new SysUser();
            sysUser.setNickname("小羽博客");
        }

        return sysUser;
    }
}
