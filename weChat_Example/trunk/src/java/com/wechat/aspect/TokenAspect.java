package com.wechat.aspect;

import com.wechat.annotation.Token;
import com.wechat.config.AccessTokenSetting;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * 校验Token切面
 * Created by fusj on 15/12/23.
 */
@Aspect
@Component
public class TokenAspect {

    private static Logger logger = LoggerFactory.getLogger(TokenAspect.class);

    @Autowired
    private AccessTokenSetting accessTokenSetting;

    /**
     * 解析是否需要判断Token令牌过期校验
     *
     * @param
     * @throws
     */
    @Before("execution(public * com.wechat.service.impl..*Impl.*(..))")
    public void before(JoinPoint point) throws Throwable {
//        System.out.println("@Before：模拟权限检查...");
//        System.out.println("@Before：目标方法为：" +
//                point.getSignature().getDeclaringTypeName() +
//                "." + point.getSignature().getName());
//        System.out.println("@Before：参数为：" + Arrays.toString(point.getArgs()));
//        System.out.println("@Before：被织入的目标对象为：" + point.getTarget());

        Method targetMethod = null;

        Method[] methods = point.getTarget().getClass().getDeclaredMethods();
        for(Method method : methods) {
            if(point.getSignature().getName().equals(method.getName())) {
                targetMethod = method;
                break;
            }
        }

        if(null == targetMethod) {
            return;
        }

        Token token = targetMethod.getAnnotation(Token.class);

        if(null != token && token.tokenCheck()) {
            long currentTime = new Date().getTime();
            long loadTime = accessTokenSetting.getLoadTime();

            // 过期前半小时加载
            if((currentTime - loadTime) / 1000 > accessTokenSetting.getAccessToken().getExpiresIn() - 1800) {
                logger.info("Loading TokenAccess");
                accessTokenSetting.initAccessToken();
            }
        }
    }
}