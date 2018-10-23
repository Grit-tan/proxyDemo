package com.grit.learn.salary_manage.proxy;

import com.grit.learn.salary_manage.Logger;
import com.grit.learn.salary_manage.Privilege;
import com.grit.learn.salary_manage.Security;

public class ProxyManageTest {
    /**
     * 代理模式:
     * 好处：
     * 把目标方法抽取独立出来了，有利于目标方法的扩展...
     * 缺点：
     * 在代理方法中，目标方法被固定写死了，一旦换了目标类，代理方法还的修改
     * @param args
     */
    public static void main(String[] args) {
        Logger logger = new Logger();
        Security security = new Security();
        Privilege privilege = new Privilege();
        privilege.setAccess("admin");
        SalaryManagerImpl target = new SalaryManagerImpl();
        SalaryManagerProxy proxy = new SalaryManagerProxy(logger, security, privilege, target);
        proxy.showSalary();
    }
}
