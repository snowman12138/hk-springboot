package com.lostself.hkspringboot.service;

import com.lostself.hkspringboot.entity.SysUser;

public interface ISysUserServiceCache {

    SysUser fingByPrimarykey(Integer key);
    SysUser updateSysuser(SysUser entity);
    SysUser insertSysuser(SysUser entity);
    int deleteByPrimarykey(Integer key);
}
