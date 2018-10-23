package com.grit.learn.salary_manage;

public class SalaryManager {

    public static void showSalary() {
        Logger logger = new Logger();
        logger.log();
        Security security = new Security();
        security.security();
        Privilege privilege = new Privilege();
        privilege.setAccess("admin");
        if ("admin".equals(privilege.getAccess())) {
            System.out.println("正在查看工资!");
        } else {
            System.out.println("您无权限查看工资");
        }
    }

    public static void main(String[] args) {
        showSalary();
        /**
         * 分析：showSalary()这里的逻辑太过拥挤了，太复杂了。
         * 所以它的扩展性太差了。
         */
    }
}
