package com.yangs.gof23.single;

/**
 * @Author Ys
 * @Date 2021年04月24日 15:22
 * @Version 1.0
 */


//饿汉式  不管有没有人进来来都会new对象 会造成内存浪费·
public class Hungry {

    private Hungry(){

    }
    private  final  static Hungry HUNGRY = new Hungry();

    public static  Hungry getInstance(){
        return  HUNGRY;
    }
}
