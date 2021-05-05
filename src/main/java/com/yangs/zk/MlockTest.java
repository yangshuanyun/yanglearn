package com.yangs.zk;

/**
 * @Author Ys
 * @Date 2021年05月03日 20:45
 * @Version 1.0
 */
public class MlockTest {

    private void  sell (){
        System.out.println("售票开始");

        int sleepTmin = 5000;
        try{
           Thread.sleep(sleepTmin);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("售票结束");
    }

    public  void  selltickWithLock() throws Exception{
        MyLock myLock = new MyLock();
        //获取锁
        myLock.acquireLock();

        sell();
        //释放锁
        myLock.releaseLock();

    }

    public static void main(String[] args) throws Exception {
        //售票员
        MlockTest  mlockTest = new MlockTest();
        for (int i =0 ; i<10;i++){
            mlockTest.selltickWithLock();
        }
    }
}
