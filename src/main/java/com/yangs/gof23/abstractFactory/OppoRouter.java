package com.yangs.gof23.abstractFactory;

/**
 * @Author Ys
 * @Date 2021年04月24日 20:16
 * @Version 1.0
 */
public class OppoRouter implements  IRouterProduct {
    @Override
    public void start() {
        System.out.println("oppo路由开机");
    }

    @Override
    public void openWife() {
        System.out.println("oppo打开路由wife");
    }
}
