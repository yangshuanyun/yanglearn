package com.yangs.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Author Ys
 * @Date 2021年05月02日 15:54
 * @Version 1.0
 */


@Configuration
public class ZookeeperConfig {
    private static final Logger logger = LoggerFactory.getLogger(ZookeeperConfig.class);

    @Value("${zookeeper.address}")
    private  static   String connectString;

    @Value("${zookeeper.timeout}")
    private   int timeout;

    static ZooKeeper  zooKeeper=null;

    public static void main(String[] args) throws Exception {

        after();
        craet();
    }

/*    private  void  creat() throws KeeperException, InterruptedException {
        zooKeeper.create("/spring","spring".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }*/

    public  static void  after() {
        try {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            //连接成功后，会回调watcher监听，此连接操作是异步的，执行完new语句后，直接调用后续代码
            //  可指定多台服务地址 127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183
            zooKeeper = new ZooKeeper("81.69.23.250:2181", 5000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if(Event.KeeperState.SyncConnected==event.getState()){
                        //如果收到了服务端的响应事件,连接成功
                        System.out.println("连接成功");
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

    private  static void  craet()throws Exception{
        // zooKeeper.create("/aad","aaa".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);

        /**
         * 创建所有人能访问的
         */
        List<ACL> acls = new ArrayList<>();
        Id id = new Id("world","anyone");
        acls.add(new ACL(ZooDefs.Perms.READ,id));
        acls.add(new ACL(ZooDefs.Perms.WRITE,id));
        zooKeeper.create("/xxx","xxx".getBytes(), acls,CreateMode.PERSISTENT);


        /**
         * 创建所有人能访问的
 /*        *//*
        List<ACL> acls = new ArrayList<>();
        Id id2 = new Id("ip","81.69.23.250");
        acls.add(new ACL(ZooDefs.Perms.ALL,id2));
        zooKeeper.create("/xxxip","xxxip".getBytes(), acls,CreateMode.PERSISTENT);
*/

        // zooKeeper.setData("/aad","sasawsa".getBytes(),-1);
        zooKeeper.exists("/aad",true);
        Stat stat =  zooKeeper.setData("/aad","sasaw22sa".getBytes(),-1);
        System.out.println(stat.getAversion());
        System.out.println("创建成功");


    }
}
