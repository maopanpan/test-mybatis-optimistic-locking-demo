package com.test.myself.test;

/**
 * 类名称：TestMain<br>
 * 类描述：<br>
 * 创建时间：2018年10月19日<br>
 *
 * @author maopanpan
 * @version 1.0.0
 */
public class TestMain {
    public static void main(String[] args) {
        Pay pay = new Pay();
        SimapleAdapter adapter = new SimapleAdapter(pay);
        adapter.sayHello();
    }
}
