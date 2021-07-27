package com.es.doc;

import com.es.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * @Author:Ys
 * @description
 * @date 2021/7/5 21:20
 */
public class ES_doc_update {

    public static void main(String[] args) throws Exception {
        RestHighLevelClient es = new RestHighLevelClient
                (RestClient.builder(new HttpHost("localhost", 9200, "http")));


        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index("user").id("1001");
        updateRequest.doc(XContentType.JSON,"sex","不男不女");


        UpdateResponse update = es.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(update.getResult());
        es.close();
    }
}
