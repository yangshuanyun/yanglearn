package com.yangs.gof23.abstractFactory;

/**
 * @Author Ys
 * @Date 2021年04月24日 20:05
 * @Version 1.0
 */
public class VivoPhone implements IphneProduct {
    @Override
    public void call() {
        System.out.println("vivo打电话");
    }

    @Override
    public void message() {
        System.out.println("vivo发短信");
    }

    @Override
    public void start() {
        System.out.println("vivo开机");
    }
}
