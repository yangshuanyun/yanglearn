package com.yangs.gof23.abstractFactory;

/**
 * @Author Ys
 * @Date 2021年04月24日 20:15
 * @Version 1.0
 */
public class OppoFactory implements  IproductFactory {
    @Override
    public IphneProduct IphneProduct() {
        return  new  OppoPhone();
    }

    @Override
    public IRouterProduct IRouterProduct() {
        return new  OppoRouter();
    }
}
