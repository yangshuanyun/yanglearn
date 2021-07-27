package com.yangs.Thread;

/**
 * @Author Ys
 * @Date 2021年05月05日 17:35
 * @Version 1.0
 */
public class TestThread implements Runnable {

    private int i = 100;

    static boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            synchronized (TestThread.class) {
                buy();
            }
        }

    }

    public static void main(String[] args) {
        TestThread thread = new TestThread();
        new Thread(thread, "name1").start();
        new Thread(thread, "name2").start();
        new Thread(thread, "name3").start();
        new Thread(thread, "name4").start();
    }
    private  void  buy(){
        synchronized (TestThread.class) {
            i--;
            if(i<=0){
                flag=false;
                return;
            }
            System.out.println(Thread.currentThread().getName() + "------拿到了第" + i + "张票");
        }
    }
}
