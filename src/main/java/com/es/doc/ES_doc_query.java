package com.es.doc;

import com.es.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Ys
 * @description
 * @date 2021/7/5 21:20
 */

/**
 *
 简单查询
 *
 */
public class ES_doc_query {

    public static void main(String[] args) throws Exception {
        RestHighLevelClient es = new RestHighLevelClient
                (RestClient.builder(new HttpHost("localhost", 9200, "http")));

        GetRequest getRequest = new GetRequest();
        getRequest.index("user").id("1001");
        GetResponse documentFields = es.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(documentFields.getSourceAsString());

        es.close();
    }
}
