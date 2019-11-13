package com.lostself.hkspringboot.service;

import com.lostself.hkspringboot.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;


public interface ISysUserService {
	SysUser findById(Long id);
}