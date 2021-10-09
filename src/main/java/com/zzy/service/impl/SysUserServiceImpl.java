package com.zzy.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zzy.dao.mapper.SysUserMapper;
import com.zzy.dao.pojo.Article;
import com.zzy.dao.pojo.SysUser;
import com.zzy.service.LoginService;
import com.zzy.service.SysUserService;
import com.zzy.vo.ErrorCode;
import com.zzy.vo.LoginUserVo;
import com.zzy.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Override
    public Result findUserByToken(String token) {


        SysUser sysUser = loginService.checkToken(token);
        if(sysUser==null){
            return Result.fail(ErrorCode.TOKEN_ERROR.getCode(),ErrorCode.TOKEN_ERROR.getMsg());
        }
        LoginUserVo loginUserVo = new LoginUserVo();
        loginUserVo.setAccount(sysUser.getAccount());
        loginUserVo.setAvatar(sysUser.getAvatar());
        loginUserVo.setId(sysUser.getId());
        loginUserVo.setNickname(sysUser.getNickname());
        return Result.success(loginUserVo);

    }

    @Override
    public SysUser findUserByAccount(String account) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getAccount,account);
        queryWrapper.last("limit 1");
        return sysUserMapper.selectOne(queryWrapper);
    }

    @Override
    public void save(SysUser sysUser) {
        this.sysUserMapper.insert(sysUser);
    }
}
