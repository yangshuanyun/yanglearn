package com.es.index;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

/**
 * @Author:Ys
 * @description
 * @date 2021/7/5 20:37
 */
public class Es_searchIndex {

 public static void main(String[] args)  throws  Exception {
  RestHighLevelClient es= new RestHighLevelClient
          (RestClient.builder(new HttpHost("localhost",9200,"http")));


  GetIndexRequest user = new GetIndexRequest("user");
  GetIndexResponse createIndexResponse=  es.indices().get(user, RequestOptions.DEFAULT);

  System.out.println(createIndexResponse.getAliases());
  System.out.println(createIndexResponse.getMappings());
  System.out.println(createIndexResponse.getSettings());
  es.close();
 }

 }

