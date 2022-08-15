package com.dbl.es.config;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.*;
import org.elasticsearch.common.unit.TimeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * descrription:
 * <p>
 * Create by DbL on 2022/8/13 10:14
 */
@Configuration
public class EsConfig {

    @Value("${spring.elasticsearch.rest.ip}")
    private String esHostName;

    @Value("${spring.elasticsearch.rest.username}")
    private String username;
    @Value("${spring.elasticsearch.rest.password}")
    private String password;

    @Value("${spring.elasticsearch.rest.port}")
    private Integer esPort;


    public static final RequestOptions COMMON_OPTIONS;

    static {
        RequestOptions.Builder builder=RequestOptions.DEFAULT.toBuilder();
        COMMON_OPTIONS=builder.build();
    }

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));
        return new RestHighLevelClient(RestClient.builder(new HttpHost(esHostName, esPort, "http"))
                .setHttpClientConfigCallback((HttpAsyncClientBuilder httpAsyncClientBuilder) -> httpAsyncClientBuilder.setDefaultCredentialsProvider(credentialsProvider)));
    }
}
