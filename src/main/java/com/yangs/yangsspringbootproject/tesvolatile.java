package com.yangs.yangsspringbootproject;

/**
 * @Author Ys
 * @Date 2021年04月21日 21:57
 * @Version 1.0
 */
public class tesvolatile {

    public  static     Boolean c=false;


    public static void main(String[] args) throws InterruptedException {


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                c=true;
            }
        });
        thread.start();
        // thread.join();
        System.out.println("-----"+c);
        while (c){
            System.out.println("-----"+c);
            System.out.println("jieshu-----------");
            break;
        }

    }
}
