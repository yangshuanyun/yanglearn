package com.es.index;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.hibernate.sql.Delete;

/**
 * @Author:Ys
 * @description
 * @date 2021/7/5 20:37
 */
public class Es_deleteIndex {

 public static void main(String[] args)  throws  Exception {
  RestHighLevelClient es= new RestHighLevelClient
          (RestClient.builder(new HttpHost("localhost",9200,"http")));


  DeleteIndexRequest user = new DeleteIndexRequest("user");
  AcknowledgedResponse delete = es.indices().delete(user, RequestOptions.DEFAULT);

  System.out.println(delete.isAcknowledged());
  es.close();
 }

 }

