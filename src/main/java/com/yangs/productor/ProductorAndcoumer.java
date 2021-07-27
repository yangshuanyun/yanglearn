package com.yangs.productor;

import com.yangs.gof23.abstractFactory.IproductFactory;

/**
 * @Author Ys
 * @Date 2021年05月07日 21:44
 * @Version 1.0
 */


class ProductorAndcoumer {

    public static void main(String[] args) {
        SynContainer synContainer  = new SynContainer();
        new Producter(synContainer).start();
        new Conmuser(synContainer).start();

    }

}


//苹果
class Apple {
    int id;
    public Apple(int id) {
        this.id = id;
    }
}

//生产者
class Producter extends Thread{
    SynContainer synContainer;

    public Producter(SynContainer synContainer){
        this.synContainer=synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synContainer.push(new Apple(i));
            System.out.println("生产了"+i+"个苹果");
        }
    }
}

//消费者
class Conmuser extends Thread {
    SynContainer synContainer;
    public Conmuser(SynContainer synContainer){
        this.synContainer=synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("吃完了"+synContainer.pop().id+"个苹果");
        }
    }
}

class SynContainer {

    int count = 0;

    // 容器大小
    Apple[] apples = new Apple[10];

    public synchronized void push(Apple apple){

        if (count == apples.length) {
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        apples[count] = apple;
        count++;
        this.notifyAll();

    }

    public synchronized Apple pop()  {
        if (count == 0) {
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        count--;
        Apple apple = apples[count];

        this.notifyAll();
        return apple;
    }

}


