package com.lostself.hkspringboot.service;

import com.github.pagehelper.PageInfo;
import com.lostself.hkspringboot.entity.SysUser;

import java.util.List;


public interface ISysUserService extends IbaseService<SysUser>{
	SysUser findById(Long id);
	List<SysUser> findAllByPage(int pagenum,int pagesize);
	PageInfo<SysUser> findAllByPage2(int pageNum, int pageSize);
}