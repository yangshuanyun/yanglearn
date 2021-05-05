package com.yangs.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Author Ys
 * @Date 2021年05月03日 19:26
 * @Version 1.0
 */
public class MyLock {

    //zk的连接
    String IP = "81.69.23.250:2181";

    //技术器
    CountDownLatch countDownLatch = new CountDownLatch(1);
    ZooKeeper zooKeeper;
    private static  final  String LOCK_ROOT_PATH = "/Locks";
    private static  final  String LOCK_NODE_NAME = "Lock_";

    private String lockPath;


    public MyLock(){
        try{
            zooKeeper = new ZooKeeper(IP, 50000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    if(watchedEvent.getType()== Event.EventType.None){
                        if(watchedEvent.getState()==Event.KeeperState.SyncConnected){
                            System.out.println("连接创建成功");
                            countDownLatch.countDown();
                        }
                    }
                }
            });
            countDownLatch.await();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //获取锁
    public   void acquireLock()throws  Exception {
        create();
        attempt();

    }

    private void create()throws  Exception {
        //判断lock是否存在，不存在就创建
         Stat stat  = zooKeeper.exists(LOCK_ROOT_PATH, false);
         if (stat == null){
             zooKeeper.create(LOCK_ROOT_PATH,new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
         }
        //创建临时有序节点
        lockPath = zooKeeper.create(LOCK_ROOT_PATH+"/"+LOCK_NODE_NAME,new byte[0],ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("节点创建成功"+lockPath);
    }


    //监视对象 ，监视上一个=节点是否被删除
    Watcher watcher = new Watcher() {
        @Override
        public void process(WatchedEvent watchedEvent) {
            if(watchedEvent.getType()==Event.EventType.NodeDeleted){
                synchronized (this){
                    notify();
                }
            }
        }
    };

    //尝试获取锁
    private  void attempt() throws  Exception {
        List<String> list =  zooKeeper.getChildren(LOCK_ROOT_PATH,false);
        //子节点排序
        Collections.sort(list);
        int index=list.indexOf(lockPath.substring(LOCK_ROOT_PATH.length()+1));
        if (index==0){
            System.out.println("获取锁成功");
            return;
        }else {
            //上一个节点的路径
            String path =  list.get(index-1);
            Stat  stat= zooKeeper.exists(LOCK_ROOT_PATH+"/"+path, watcher);
            if(stat==null){
                attempt();
            }else {
                synchronized (watcher){
                    watcher.wait();
                }
                //继续获取锁
                attempt();
            }
        }
    }


    //释放锁
    public void releaseLock() throws  Exception {
        zooKeeper.delete(this.lockPath,-1);
        zooKeeper.close();
        System.out.println("锁释放了");
    }


    public static void main(String[] args) {
        try{
            MyLock myLock = new MyLock();
            myLock.create();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
