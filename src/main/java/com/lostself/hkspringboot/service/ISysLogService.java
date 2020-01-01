package com.lostself.hkspringboot.service;

import com.lostself.hkspringboot.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;

public interface ISysLogService {
    /*
    *插入日志
    * */
    int insertLog(SysLog entity);
}
