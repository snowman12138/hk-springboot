package com.lostself.hkspringboot.service.imp;

import com.lostself.hkspringboot.dao.SysUserMapper;
import com.lostself.hkspringboot.entity.SysUser;
import com.lostself.hkspringboot.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.chrono.IsoChronology;

@Service("sysUserService")
public class SysUserServiceImpl implements ISysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findById(Long id) {

       return sysUserMapper.findById(id);

    }
}
