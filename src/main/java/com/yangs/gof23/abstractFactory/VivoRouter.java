package com.yangs.gof23.abstractFactory;

/**
 * @Author Ys
 * @Date 2021年04月24日 20:17
 * @Version 1.0
 */
public class VivoRouter implements IRouterProduct {
    @Override
    public void start() {
        System.out.println("vivo手机开机");
    }

    @Override
    public void openWife() {
        System.out.println("vivo打开wife");
    }
}
