package com.dbl.es.config;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

/**
 * descrription:
 * <p>
 * Create by DbL on 2022/8/13 10:35
 */
@Component
@Slf4j
public class EsBulkConfig {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Bean
    public BulkProcessor bulkProcessor() {
        BiConsumer<BulkRequest, ActionListener<BulkResponse>> bulkConsumer =
                (request, bulkListener) -> restHighLevelClient.bulkAsync(request, RequestOptions.DEFAULT, bulkListener);

        return BulkProcessor.builder(bulkConsumer, new BulkProcessor.Listener() {
            @Override
            public void beforeBulk(long executionId, BulkRequest request) {
                //在这儿你可以自定义执行同步之前执行什么
            }

            @SneakyThrows
            @Override
            public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
                //在这儿你可以自定义执行完同步之后执行什么
            }

            @Override
            public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
                //写入失败后
                log.error("ES写入失败", failure);
            }
        }).setBulkActions(10000) //  达到刷新的条数
                .setFlushInterval(TimeValue.timeValueSeconds(10)).build(); // 固定刷新的时间频率
    }
}
