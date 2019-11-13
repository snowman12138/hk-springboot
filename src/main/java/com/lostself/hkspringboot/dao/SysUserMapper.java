package com.lostself.hkspringboot.dao;

import com.lostself.hkspringboot.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper {

    public SysUser findById(long id);
}
