package com.test.myself.test;

/**
 * 类名称：SimapleAdapter<br>
 * 类描述：<br>
 * 创建时间：2018年10月19日<br>
 *
 * @author maopanpan
 * @version 1.0.0
 */
public class SimapleAdapter {

    private Pay pay;

    public SimapleAdapter(Pay pay) {
        this.pay = pay;
    }

    public void sayHello() {
        pay.payment();
    }
}
