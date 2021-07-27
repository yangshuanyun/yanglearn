package com.es.index;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

/**
 * @Author:Ys
 * @description
 * @date 2021/7/5 20:37
 */
public class Es_careatIndex {

 public static void main(String[] args)  throws  Exception {
  RestHighLevelClient es= new RestHighLevelClient
          (RestClient.builder(new HttpHost("localhost",9200,"http")));


  CreateIndexRequest request =  new CreateIndexRequest("user");
  CreateIndexResponse createIndexResponse=  es.indices().create(request, RequestOptions.DEFAULT);

  boolean isAcknowledged= createIndexResponse.isAcknowledged();
  System.out.println("索引操作"+isAcknowledged);
  es.close();
 }

 }

