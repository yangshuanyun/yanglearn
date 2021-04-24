package com.yangs.yangsspringbootproject;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component("mQUtil")
public class Account {

    String name;
    String doublance;

    public synchronized  void set(String name ,double banlance ){

        this.name=name;
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

         this.doublance = doublance;

    }

    public  String  getBlance(String name){
        return  this.doublance;
    }

    public static void main(String[] args) {

        Account a = new Account();
        new Thread(()->a.set("zhangsan",1000)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(a.getBlance("zhangsan"));

        try{
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(a.getBlance("zhangsan"));
    }
}
