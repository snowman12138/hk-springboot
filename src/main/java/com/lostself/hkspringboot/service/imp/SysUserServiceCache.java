package com.lostself.hkspringboot.service.imp;

import com.lostself.hkspringboot.dao.SysUserMapper;
import com.lostself.hkspringboot.entity.SysUser;
import com.lostself.hkspringboot.service.ISysUserServiceCache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("sysUserServiceCache")
public class SysUserServiceCache implements ISysUserServiceCache {

    private final static Logger log = LoggerFactory.getLogger(SysUserServiceCache.class);

    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    @Cacheable(value = "userCache",key = "#key")
    public SysUser fingByPrimarykey(Integer key) {

        log.debug("去数据库查询了数据");
        return sysUserMapper.findById((long)key);
    }

    @Override
    public SysUser updateSysuser(SysUser entity) {
        return null;
    }

    @Override
    public SysUser insertSysuser(SysUser entity) {
        return null;
    }

    @Override
    public int deleteByPrimarykey(Integer key) {
        return 0;
    }
}
