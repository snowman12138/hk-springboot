package com.lostself.hkspringboot.config;


import com.lostself.hkspringboot.entity.SysLog;
import com.lostself.hkspringboot.service.ISysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MemberSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 *     @Aspect:这个注解表示将当前类视为一个切面类
 *     @Component：表示将当前类交由Spring管理。
 *     @Pointcut:切点表达式,定义我们的匹配规则，上边我们使用@Pointcut("@annotation(com.web.springbootaoplog.config.Log)")表示匹配带有我们自定义注解的方法。
 *     @Around:环绕通知，可以在目标方法执行前后执行一些操作，以及目标方法抛出异常时执行的操作。*/

@Aspect
@Component
public class LogAsPect {

    private final static Logger log = org.slf4j.LoggerFactory.getLogger(LogAsPect.class);

    @Autowired
    private ISysLogService sysLogService;
    @Pointcut("@annotation(com.lostself.hkspringboot.config.Log)")
    public void poincut(){}

    @Around("poincut()")
    public Object around(ProceedingJoinPoint point){
        Object result = null;
        long beginTime = System.currentTimeMillis();

        log.info("我在目标方法之前执行！");
        try {
            result = point.proceed();
//            long endTime = System.currentTimeMillis();
            insertLog(point,beginTime);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        log.info("我在目标方法之后执行！");
        return result;
    }

    private void insertLog(ProceedingJoinPoint point, long time) {

        MemberSignature signature = (MethodSignature)point.getSignature();
        Method method = ((MethodSignature) signature).getMethod();
        SysLog sys_Log = new SysLog();

        Log userAction = method.getAnnotation(Log.class);
        if (userAction != null){
            //注解上的描述
            sys_Log.setUserAction(userAction.value());
        }

        //请求的类名
        String className = point.getTarget().getClass().getName();
        //请求的方法名
        String methodName = signature.getName();
        //请求的参数值
        String args = Arrays.toString(point.getArgs());

        //从session重获得当前登陆人的id
        //Long useride = (Long)SecurityUtils.getSubject().getSession().getAttribute("userid");
        long userid = 1l;
        sys_Log.setUserId((int) userid);
//        sys_Log.setId(userid);
        sys_Log.setCreateTime(new java.sql.Timestamp(new Date().getTime()));
        long endTime = System.currentTimeMillis();
        log.info("当前登录用户：{}，类名：{}，方法名：{}，参数：{},时间：{}",userid, className, methodName, args, endTime - time);

        sysLogService.insertLog(sys_Log);
    }
}
