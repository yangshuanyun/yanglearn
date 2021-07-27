package com.es.doc;

import org.apache.http.HttpHost;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @Author:Ys
 * @description
 * @date 2021/7/5 21:20
 */
public class ES_doc_del {

    public static void main(String[] args) throws Exception {
        RestHighLevelClient es = new RestHighLevelClient
                (RestClient.builder(new HttpHost("localhost", 9200, "http")));

        DeleteRequest deleteRequest = new DeleteRequest();
        deleteRequest.index("user").id("1001");
        DeleteResponse delete = es.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(delete.toString());

        es.close();
    }
}
