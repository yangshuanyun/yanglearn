package com.yangs.gof23.single;

/**
 * @Author Ys
 * @Date 2021年04月24日 15:55
 * @Version 1.0
 */
public class LazyMan {

    private LazyMan(){
        System.out.println("name-----------"+Thread.currentThread().getName());
    }

    public  volatile static   LazyMan lanzy;


    //双重检查 适合多线程 且要防止指令重排序 要加上volatile
    public     static  LazyMan getInstance(){
        if(lanzy == null ){
            synchronized (LazyMan.class){
                if (lanzy==null){
                     lanzy = new LazyMan(); //会存在指令重排序问题 要在定义时加上volatile
                }
            }
        }
        return  lanzy;
    }

    public static void main(String[] args) {
        for (int i=0;i<3;i++){
            new Thread(()->{
                LazyMan.getInstance();
            }).start();

        }

    }
}
