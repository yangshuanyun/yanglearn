package com.yangs.gof23.abstractFactory;

/**
 * @Author Ys
 * @Date 2021年04月24日 20:20
 * @Version 1.0
 */
public class VivoFactory implements IproductFactory {
    @Override
    public IphneProduct IphneProduct() {
        return new VivoPhone();
    }

    @Override
    public IRouterProduct IRouterProduct() {
        return new VivoRouter();
    }
}
