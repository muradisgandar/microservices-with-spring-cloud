package com.company.ticketservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories
@ComponentScan("com.company")
public class TicketConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
