package com.ys.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author Ys
 * @Date 2021年05月16日 17:55
 * @Version 1.0
 */
public class MybaitsUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "mybaits-config.xml";
        try {
            //使用mybaits获取sqlsession对象
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //sqlsession 实例包含面向数据执行的命令的所有方法
    public  static SqlSession getSqlSession(){
        return  sqlSessionFactory.openSession();
    }
}
