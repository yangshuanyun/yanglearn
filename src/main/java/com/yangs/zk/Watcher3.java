package com.yangs.zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * @Author Ys
 * @Date 2021年05月03日 18:50
 * @Version 1.0
 */
public class Watcher3 implements Watcher {





    static ZooKeeper zooKeeper;

    public static void main(String[] args) {
        getData();
    }

    @Override
    public  void process(WatchedEvent watchedEvent) {
        if(watchedEvent.getType()== Event.EventType.None){
            if(watchedEvent.getState()==Event.KeeperState.SyncConnected){
                System.out.println("连接成功");
            }
        }
    }


    private static void  getData()   {
        try{
            zooKeeper= new ZooKeeper("81.69.23.250:2181", 50000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {

                }
            });

            Stat stat = new Stat();
            byte []  bytes =  zooKeeper.getData("/aad",false,stat);
            System.out.println(new String(bytes));

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
