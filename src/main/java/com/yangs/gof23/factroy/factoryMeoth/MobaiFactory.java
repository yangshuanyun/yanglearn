package com.yangs.gof23.factroy.factoryMeoth;

/**
 * @Author Ys
 * @Date 2021年04月24日 17:21
 * @Version 1.0
 */
public class MobaiFactory implements CarFactory {
    @Override
    public  Car getCar() {
        return new Mobai();
    }
}
