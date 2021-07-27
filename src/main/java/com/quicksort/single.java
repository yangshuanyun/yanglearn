package com.quicksort;

/**
 * @Author:Ys
 * @description
 * @date 2021/7/4 15:11
 */
//饿汉式
class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton() {
    }
    static Singleton getInstance() {
        return instance;
    }
}

//懒汉
class Singleton2 {
    private static Singleton2 singleton2 = null;
    private Singleton2() {
    }
    static Singleton2 getInstance() {
        if (singleton2 == null) {
            synchronized (Singleton2.class){
                singleton2 = new Singleton2();
            }
        }
        return singleton2;
    }

}

