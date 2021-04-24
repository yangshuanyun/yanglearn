package com.yangs.yangsspringbootproject;

import javax.xml.bind.SchemaOutputResolver;

/**
 * @Author Ys
 * @Date 2021年04月21日 14:08
 * @Version 1.0
 */
public class testThread {


    public   static volatile int x = 0;

    public static  void main(String[] args) throws InterruptedException {

        System.out.println("--------- " + x);

        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int a = 0; a < 100; a++) {
                        add();
                    }
                }
            });
            threads[i].start();
        }
        for (Thread t :threads){
            t.join();
        }
        System.out.println("===============  "+x);
    }

    public synchronized static void add() {
        x++;
    }

}


