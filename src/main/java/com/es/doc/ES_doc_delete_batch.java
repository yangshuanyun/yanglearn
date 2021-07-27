package com.es.doc;

import com.es.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * @Author:Ys
 * @description
 * @date 2021/7/27 22:53
 */
public class ES_doc_delete_batch {

    public static void main(String[] args) throws  Exception {
        RestHighLevelClient es = new RestHighLevelClient
                (RestClient.builder(new HttpHost("localhost", 9200, "http")));

        //索引请求
        BulkRequest bulkRequest = new BulkRequest();

        bulkRequest.add(new DeleteRequest().index("user").id("100"));
        bulkRequest.add(new DeleteRequest().index("user").id("101"));
        bulkRequest.add(new DeleteRequest().index("user").id("102"));
        bulkRequest.add(new DeleteRequest().index("user").id("103"));
        bulkRequest.add(new DeleteRequest().index("user").id("104"));
        bulkRequest.add(new DeleteRequest().index("user").id("105"));
        bulkRequest.add(new DeleteRequest().index("user").id("106"));
        bulkRequest.add(new DeleteRequest().index("user").id("107"));
        bulkRequest.add(new DeleteRequest().index("user").id("108"));
        bulkRequest.add(new DeleteRequest().index("user").id("109"));
        bulkRequest.add(new DeleteRequest().index("user").id("111"));
        bulkRequest.add(new DeleteRequest().index("user").id("112"));
        bulkRequest.add(new DeleteRequest().index("user").id("113"));
        bulkRequest.add(new DeleteRequest().index("user").id("114"));
        bulkRequest.add(new DeleteRequest().index("user").id("115"));
        bulkRequest.add(new DeleteRequest().index("user").id("116"));
        bulkRequest.add(new DeleteRequest().index("user").id("117"));


        //传json格式的数据
        BulkResponse bulkResponse = es.bulk(bulkRequest, RequestOptions.DEFAULT);

        System.out.println(bulkResponse.getTook());
        System.out.println(bulkResponse.getItems());
        es.close();


    }

}
