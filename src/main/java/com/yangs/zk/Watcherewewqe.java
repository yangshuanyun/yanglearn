package com.yangs.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * @Author Ys
 * @Date 2021年05月03日 16:26
 * @Version 1.0
 */


public class Watcherewewqe {

    public static void main(String[] args) throws KeeperException, InterruptedException {
        after();
        watcher2();
    }

    private static final Logger logger = LoggerFactory.getLogger(ZookeeperConfig.class);
    static ZooKeeper zooKeeper;


    public  static void  after() {
        try {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            //连接成功后，会回调watcher监听，此连接操作是异步的，执行完new语句后，直接调用后续代码
            //  可指定多台服务地址 127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183
            zooKeeper = new ZooKeeper("81.69.23.250:2181", 5000, new org.apache.zookeeper.Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if(Event.KeeperState.SyncConnected==event.getState()){
                        //如果收到了服务端的响应事件,连接成功
                        System.out.println("连接成功");
                        System.out.println("path="+event.getPath());
                        System.out.println("eventType"+event.getType());
                        countDownLatch.countDown();
                    }
                    if(Event.KeeperState.Disconnected ==event.getState()){
                        System.out.println("断开连接");

                    }
                }
            });
            // zooKeeper.create("/spring","spring".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            countDownLatch.await();
            logger.info("【初始化ZooKeeper连接状态....】={}",zooKeeper.getState());

        }catch (Exception e){
            e.printStackTrace();
            logger.error("初始化ZooKeeper连接异常....】={}",e);
        }
    }


    /**
     * 自定义watcher
     */
/*
    private  void  wather1(){
        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("");
            }

        };
    }
*/

    private  static void  watcher2() throws KeeperException, InterruptedException {
        org.apache.zookeeper.Watcher watcher = new org.apache.zookeeper.Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                try{
                    System.out.println("/aad"+watchedEvent.getPath());
                    System.out.println("evenType"+watchedEvent.getType());
                    zooKeeper.exists("/aad",this);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        zooKeeper.exists("/aad",watcher);
        Thread.sleep(50000);
        System.out.println("结束");
    }

    private static void  watcher3() throws KeeperException, InterruptedException {

        zooKeeper.exists("/aad", new org.apache.zookeeper.Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("/自定义");
                System.out.println("path="+watchedEvent.getPath());
                System.out.println("eventType="+watchedEvent.getType());

            }
        });
        Thread.sleep(50000);
        System.out.println("结束");


    }



}