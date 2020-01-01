package com.lostself.hkspringboot.service.imp;

import com.lostself.hkspringboot.dao.SysLogMapper;
import com.lostself.hkspringboot.entity.SysLog;
import com.lostself.hkspringboot.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysLogService")
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public int insertLog(SysLog entity) {
        int insert = sysLogMapper.insert(entity);

        return insert;

    }
}
