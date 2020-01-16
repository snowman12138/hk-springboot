package com.lostself.hkspringboot.service.imp;

import com.lostself.hkspringboot.dao.SysUserMapper;
import com.lostself.hkspringboot.entity.SysUser;
import com.lostself.hkspringboot.service.ISysUserServiceCache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
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

        log.info("去数据库查询了数据");
        return sysUserMapper.findById((long)key);
    }

    @Override
    @CachePut (value = "userCache", key = "#p0.id")
    public SysUser updateSysuser(SysUser entity) {

        log.debug("更新了数据库id为:{}的数据",entity.getId());
        int res = sysUserMapper.updateByPrimaryKey(entity);
        if (res > 0){
            return entity;
        }else {
            return null;
        }
    }

    @Override
    @Cacheable(value = "userCache",key = "#p0.id")
    public SysUser insertSysuser(SysUser entity) {

        log.info("新添加了一条id为:{}的数据",entity.getId());
        int res = sysUserMapper.insert(entity);
        if (res > 0){
            return entity;
        }else {
            return null;
        }
    }

    @Override
    @CacheEvict(value = "userCache",key = "#key",allEntries = false,beforeInvocation = true)
    public int deleteByPrimarykey(Integer key) {

        log.info("删除了id为:{}的一条数据",key);
        return sysUserMapper.deleteByPrimaryKey(key);
    }
}
