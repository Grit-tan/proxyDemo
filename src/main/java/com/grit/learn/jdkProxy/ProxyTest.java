package com.grit.learn.jdkProxy;


import java.lang.reflect.Proxy;

/**
 * 1、拦截器的作用究竟是什么？
 *     *  给目标类及其他的类赋值
 *     *  拦截器中的invoke方法体就是代理对象体
 * 2、代理对象的方法体是什么？
 *     就是拦截器中invoke方法中的内容
 * 3、在拦截器中有一个方法为invoke方法的第二个参数method,该参数是什么时候传递进去的
 *     代理对象调用方法的时候，就进入了拦截器中invoke方法中，将目标类的方法传进去，赋值给method
 * 4、动态代理模式到底解决了什么问题
 *      将日志记录，安全性框架，权限验证以及查看工资（业务逻辑）整合在一起了
 * @author Administrator
 */
public class ProxyTest {

    public static void main(String[] args) {
        Logger logger = new Logger();
        Security security = new Security();
        Privilege privilege = new Privilege();
        privilege.setAccess("admin");
        SalaryManagerImpl target = new SalaryManagerImpl();
        SalaryInterceptor salaryInterceptor = new SalaryInterceptor(logger, security, privilege, target);
        /**
         *  newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
         *  @param   loader the class loader to define the proxy class
         *  @param   interfaces the list of interfaces for the proxy class to implement
         *  @param   h the invocation handler to dispatch method invocations to
         *  目的是：通过目标类，动态生成目标对象的代理对象
         */
        SalaryManagerInterface proxyInstance = (SalaryManagerInterface)Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), salaryInterceptor);
        proxyInstance.showSalary();//SalaryInterceptor拦截器中的invoke()方法体，其实就是代理对象的方法体

    }
}
