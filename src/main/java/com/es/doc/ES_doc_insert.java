package com.es.doc;

import com.es.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * @Author:Ys
 * @description
 * @date 2021/7/27 22:53
 */
public class ES_doc_insert {

    public static void main(String[] args) throws  Exception {
        RestHighLevelClient es = new RestHighLevelClient
                (RestClient.builder(new HttpHost("localhost", 9200, "http")));

        //索引请求
        IndexRequest indexRequest = new IndexRequest();
        indexRequest.index("user").id("1002");

        //用户实体
        User user = new User();
        user.setSex("男");
        user.setAge(20);
        user.setName("yang");


        //传json格式的数据
        ObjectMapper objectMapper = new ObjectMapper();
        String userJson = objectMapper.writeValueAsString(user);
        indexRequest.source(userJson, XContentType.JSON);
        IndexResponse indexResponse = es.index(indexRequest, RequestOptions.DEFAULT);

        System.out.println(indexResponse.getResult());
        es.close();


    }

}
