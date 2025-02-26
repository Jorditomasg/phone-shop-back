package com.phoneshop.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${api.url}")
    private String apiUrl;

    public String getApiUrl() {
        return apiUrl;
    }
}
