package com.ys.dao.mybatis;

import com.ys.mybatis.dao.CloudAccountMapper;
import com.ys.mybatis.pojo.CloudAccount;
import com.ys.mybatis.utils.MybaitsUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author Ys
 * @Date 2021年05月16日 18:36
 * @Version 1.0
 */
public class CloudAccountTest {

    @Test
    public  void  test(){
        //获取sqlssssion对象
        SqlSession sqlSession =  MybaitsUtils.getSqlSession();
        //执行sql
        CloudAccountMapper cloudAccountMapper =  sqlSession.getMapper(CloudAccountMapper.class);

        List<CloudAccount> list =  cloudAccountMapper.getCloudAccountList();
        for (CloudAccount cloudAccount : list) {
            System.out.println(cloudAccount);

        }
        sqlSession.close();

    }
}
