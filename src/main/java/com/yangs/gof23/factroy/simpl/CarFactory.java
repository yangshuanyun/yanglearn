package com.yangs.gof23.factroy.simpl;

/**
 * @Author Ys
 * @Date 2021年04月24日 17:03
 * @Version 1.0
 */
public class CarFactory {



    public  static   Car   getFactory(String car ){
        if(car.equals("五菱")){
            return  new Wuling();
        }else  if(car.equals("摩拜")){
            return  new Mobai();
        }else {
            return  null;
        }
    }
}
