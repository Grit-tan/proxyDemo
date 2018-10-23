package com.grit.learn.jdkProxy;

public class SalaryManagerImpl implements SalaryManagerInterface {

    @Override
    public void showSalary() {
        System.out.println("正在查看工资，涨了2w...");
    }
}
