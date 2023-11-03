package com.easyblog.main.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/*@Configuration
@EnableElasticsearchRepositories(basePackages = "com.easyblog.main.repository")
public class ElasticConfiguration extends ElasticsearchConfiguration {

    @Override
    public  ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo("search-easyblog-elasticsearch-7dsm4qrwnjtybpoogbd5jjnkgq.us-east-1.es.amazonaws.com")
                .build();
    }
}*/

