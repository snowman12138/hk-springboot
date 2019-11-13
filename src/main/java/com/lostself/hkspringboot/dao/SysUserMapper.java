package com.lostself.hkspringboot.dao;

import com.lostself.hkspringboot.entity.SysUser;
import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    List<SysUser> selectAll();

    int updateByPrimaryKey(SysUser record);

    public SysUser findById(Long id);
}