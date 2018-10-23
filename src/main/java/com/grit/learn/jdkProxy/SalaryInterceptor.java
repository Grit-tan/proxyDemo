package com.grit.learn.jdkProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * jdk的动态代理
 *  实现InvocationHandler的拦截器
 *  1.把日志，安全性框架，权限验证导入
 *  2.把目标类导入进去
 *  3.上述两类通过构造函数赋值
 */
public class SalaryInterceptor implements InvocationHandler {

    private Logger logger;//日志记录
    private Security security;//安全性检查
    private Privilege privilege;// 权限验证

    private Object target;// 目标实例

    public SalaryInterceptor(Logger logger, Security security, Privilege privilege, Object target) {
        this.logger = logger;
        this.security = security;
        this.privilege = privilege;
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.logger.log();
        this.security.security();
        if ("admin".equals(this.privilege.getAccess())) {
            //调用目标对象的方法
            method.invoke(this.target, args);
        } else {
            System.out.println("您无权限查看...");
        }
        return null;
    }


}
