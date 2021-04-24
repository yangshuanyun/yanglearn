package com.yangs.gof23.factroy.factoryMeoth;

/**
 * @Author Ys
 * @Date 2021年04月24日 17:36
 * @Version 1.0
 */
public class TeSilaFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Tesila();
    }
}
