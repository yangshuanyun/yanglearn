package com.es.doc;

import com.es.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
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
public class ES_doc_insert_batch {

    public static void main(String[] args) throws  Exception {
        RestHighLevelClient es = new RestHighLevelClient
                (RestClient.builder(new HttpHost("localhost", 9200, "http")));

        //索引请求
        BulkRequest bulkRequest = new BulkRequest();

        bulkRequest.add(new IndexRequest().index("user").id("100").source(XContentType.JSON,"name","aa","age",20,"sex","男"));
        bulkRequest.add(new IndexRequest().index("user").id("101").source(XContentType.JSON,"name","bb","age",20,"sex","女"));
        bulkRequest.add(new IndexRequest().index("user").id("102").source(XContentType.JSON,"name","cc","age",20,"sex","男"));
        bulkRequest.add(new IndexRequest().index("user").id("103").source(XContentType.JSON,"name","dd","age",25,"sex","男"));
        bulkRequest.add(new IndexRequest().index("user").id("104").source(XContentType.JSON,"name","ff","age",52,"sex","女"));
        bulkRequest.add(new IndexRequest().index("user").id("105").source(XContentType.JSON,"name","ee","age",20,"sex","女"));
        bulkRequest.add(new IndexRequest().index("user").id("106").source(XContentType.JSON,"name","rr","age",78,"sex","男"));

        //用户实体
        User user = new User();
        user.setSex("男");
        user.setAge(20);
        user.setName("yang");


        //传json格式的数据
        BulkResponse bulkResponse = es.bulk(bulkRequest, RequestOptions.DEFAULT);

        System.out.println(bulkResponse.getTook());
        System.out.println(bulkResponse.getItems());
        es.close();


    }

}
