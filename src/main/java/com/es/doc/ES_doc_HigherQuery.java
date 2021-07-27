package com.es.doc;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;

import javax.naming.directory.SearchResult;

/**
 * @Author:Ys
 * @description
 * @date 2021/7/5 21:20
 */

/**
 *
 复杂查询
 *
 */
public class ES_doc_HigherQuery {

    public static void main(String[] args) throws Exception {
        RestHighLevelClient es = new RestHighLevelClient
                (RestClient.builder(new HttpHost("localhost", 9200, "http")));

        //全量查询
        /*SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");
        new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        SearchRequest source = searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
        SearchResponse searchResponseearch = es.search(source, RequestOptions.DEFAULT);
        SearchHits hits = searchResponseearch.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(searchResponseearch.getTook());
        for (SearchHit hit: hits){
            System.out.println(hit.getSourceAsString());
        }*/

        //条件查询
        /*SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");
        new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        SearchRequest source = searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("age",20)));
        SearchResponse searchResponseearch = es.search(source, RequestOptions.DEFAULT);
        SearchHits hits = searchResponseearch.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(searchResponseearch.getTook());
        for (SearchHit hit: hits){
            System.out.println(hit.getSourceAsString());
        }*/

        //分页查询
        /*SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");
        new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        //（当前页面-1)*每页显示条数
        builder.from(3);
        builder.size(2);
        SearchRequest source = searchRequest.source(builder);
        SearchResponse searchResponseearch = es.search(source, RequestOptions.DEFAULT);
        SearchHits hits = searchResponseearch.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(searchResponseearch.getTook());
        for (SearchHit hit: hits){
            System.out.println(hit.getSourceAsString());
        }*/

        //排序查询
        /*SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");
        new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        builder.sort("age", SortOrder.ASC);
        SearchRequest source = searchRequest.source(builder);
        SearchResponse searchResponseearch = es.search(source, RequestOptions.DEFAULT);
        SearchHits hits = searchResponseearch.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(searchResponseearch.getTook());
        for (SearchHit hit: hits){
            System.out.println(hit.getSourceAsString());
        }*/

        //过滤字段
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");
        new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        builder.sort("age", SortOrder.ASC);
        SearchRequest source = searchRequest.source(builder);
        SearchResponse searchResponseearch = es.search(source, RequestOptions.DEFAULT);
        SearchHits hits = searchResponseearch.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(searchResponseearch.getTook());
        for (SearchHit hit: hits){
            System.out.println(hit.getSourceAsString());
        }

        es.close();
    }
}
