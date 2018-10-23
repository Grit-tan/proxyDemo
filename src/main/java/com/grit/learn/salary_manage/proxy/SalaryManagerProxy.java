package com.grit.learn.salary_manage.proxy;

import com.grit.learn.salary_manage.Logger;
import com.grit.learn.salary_manage.Privilege;
import com.grit.learn.salary_manage.Security;

/**
 * 1.导入日志，安全性框架，权限
 * 2.目标对象
 * 3.在代理对象的方法中调用目标对象的方法
 */
public class SalaryManagerProxy implements SalaryManagerInterface{

    private Logger logger;//日志记录
    private Security security;//安全性检查
    private Privilege privilege;// 权限验证
    private SalaryManagerImpl target;// 目标对象

    public SalaryManagerProxy(Logger logger, Security security, Privilege privilege, SalaryManagerImpl target) {
        this.logger = logger;
        this.security = security;
        this.privilege = privilege;
        this.target = target;
    }

    @Override
    public void showSalary() {
        this.logger.log();
        this.security.security();
        if ("admin".equals(this.privilege.getAccess())) {
            this.target.showSalary();
        } else {
            System.out.println("您无权限查看工资...");
        }
    }
}
