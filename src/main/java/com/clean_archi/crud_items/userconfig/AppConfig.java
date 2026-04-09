package com.clean_archi.crud_items.userconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public String appName() {
        return "CRUD Items Application";
    }

    @Bean
    public int maxItems() {
        return 100;
    }

    @Bean
    public boolean featureEnabled() {
        return true;
    }
}