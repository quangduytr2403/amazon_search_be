package com.example.amazonsearchbe.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.example.amazonsearchbe.properties.ElasticSearchProperties;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ElasticSearchClientConfig {

    private final ElasticSearchProperties properties;

    @Bean
    public ElasticsearchClient elasticsearchClient() {
        JacksonJsonpMapper jacksonJsonpMapper = new JacksonJsonpMapper();
        ElasticsearchTransport transport = new RestClientTransport(buildRestClient(), jacksonJsonpMapper);
        return new ElasticsearchClient(transport);
    }

    private RestClient buildRestClient() {
        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials(properties.getRest().getUsername(), properties.getRest().getPassword()));

        RestClientBuilder builder = RestClient.builder(HttpHost.create(properties.getRest().getUris()))
                .setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider));
        return builder.build();
    }
}
