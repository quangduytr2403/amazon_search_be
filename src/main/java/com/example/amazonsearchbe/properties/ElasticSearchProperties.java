package com.example.amazonsearchbe.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "elasticsearch")
@Data
public class ElasticSearchProperties {
    private Rest rest = new Rest();
    private Index index = new Index();

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Rest {
        private String uris;
        private String username;
        private String password;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Index {
        private String product;
    }
}
