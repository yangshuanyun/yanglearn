package com.yangs.gof23.abstractFactory;

/**
 * @Author Ys
 * @Date 2021年04月24日 20:03
 * @Version 1.0
 */
public class OppoPhone  implements  IphneProduct{
    @Override
    public void call() {
        System.out.println("oppo打电话");
    }

    @Override
    public void message() {
        System.out.println("oppo发短信");
    }

    @Override
    public void start() {
        System.out.println("oppe开机");
    }
}
