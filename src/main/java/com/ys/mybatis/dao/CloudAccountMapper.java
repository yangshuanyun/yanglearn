package com.ys.mybatis.dao;

import com.ys.mybatis.pojo.CloudAccount;

import java.util.List;

/**
 * @Author Ys
 * @Date 2021年05月16日 18:15
 * @Version 1.0
 */
public interface CloudAccountMapper {
    List<CloudAccount> getCloudAccountList();

}
