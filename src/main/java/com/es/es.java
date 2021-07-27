package com.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @Author:Ys
 * @description
 * @date 2021/7/5 20:37
 */
public class es {

 public static void main(String[] args)  throws  Exception {
  RestHighLevelClient es= new RestHighLevelClient
          (RestClient.builder(new HttpHost("localhost",9200,"http")));


  es.close();
 }

 }

