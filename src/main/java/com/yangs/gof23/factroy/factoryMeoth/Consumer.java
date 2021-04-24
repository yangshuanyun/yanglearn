package com.yangs.gof23.factroy.factoryMeoth;

import java.io.CharArrayReader;

/**
 * @Author Ys
 * @Date 2021年04月24日 17:07
 * @Version 1.0
 */
public class Consumer {
    public static void main(String[] args) {

/*      Car car1 =   CarFactory.getFactory("五菱");
      Car car2=   CarFactory.getFactory("摩拜");*/

/*      car1.name();
      car2.name();*/
       Car car1= new MobaiFactory().getCar();
       Car car2= new WulingFactory().getCar();
       Car car3= new TeSilaFactory().getCar();

       car1.name();
       car2.name();
       car3.name();

    }





}
