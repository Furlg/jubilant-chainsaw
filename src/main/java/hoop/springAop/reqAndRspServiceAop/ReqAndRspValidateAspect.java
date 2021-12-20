/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoop.springAop.reqAndRspServiceAop;

import hoop.Trade.CommTrade.TradeFieldServiceImp;
import java.util.Objects;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author 沙建斌  A-8626 
 * @date 2021-12-12
 * @version 1.0
 * @description 此类主要对请求体和返回体进行切面编程
 */
@Component
@Aspect
@Slf4j
public class ReqAndRspValidateAspect {
    
    @Resource
    TradeFieldServiceImp tradeFieldServiceImp;
    
    /**
     * pointCut主要是用来标标记一个字符串用来只指示需要进行切面编程的点--待补充
     */
    
    
    @Pointcut("execution(* hoop.Trade..*ServiceImp.*(..))")
    private void pointCutParam(){}
    
    /**
     * Before Advice
     */
    @Before("pointCutParam()")
    public void reqParamsValidateBefore(JoinPoint jonPoint ){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest          request = Objects.requireNonNull(attributes).getRequest();
                                    
                    Object[] objects        = jonPoint.getArgs();
                            for(int i = 0;i<objects.length;i++){
                                System.out.println("request"+request);
                            }
    }
    /**
     * Around Advice 
     */
//    @Around("pointCutParam()")
//    public void reqParamsValidate(ProceedingJoinPoint pjp){
//            log.error("环绕前");
//            log.error("getClass："+pjp.getClass());
//            log.error("GETARGS"+pjp.getArgs());
//            log.error("GETTARGET"+pjp.getTarget());
//            log.error("getSignature()"+pjp.getSignature());
//            log.error("getThis()"+pjp.getThis());
//    }
    /**
     * 这个方法主要是用来调用TradeFieldServiceImp类,并进行字段的校验
     */
    
    
}
