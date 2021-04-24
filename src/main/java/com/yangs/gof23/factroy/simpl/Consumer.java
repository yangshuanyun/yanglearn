package com.yangs.gof23.factroy.simpl;

/**
 * @Author Ys
 * @Date 2021年04月24日 17:07
 * @Version 1.0
 */
public class Consumer {
    public static void main(String[] args) {

      Car car1 =   CarFactory.getFactory("五菱");
      Car car2=   CarFactory.getFactory("摩拜");

      car1.name();
      car2.name();
    }





}
