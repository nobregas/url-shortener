package br.com.urlshortener.urlshortener.infra.config;

import br.com.urlshortener.urlshortener.domain.adapters.services.UrlServiceImpl;
import br.com.urlshortener.urlshortener.domain.ports.interfaces.UrlServicePort;
import br.com.urlshortener.urlshortener.domain.ports.repositories.UrlRepositoryPort;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class BeanConfig {

    @Bean
    UrlServicePort urlService(UrlRepositoryPort urlRepositoryPort) {
        return new UrlServiceImpl(urlRepositoryPort);
    }

    @Bean
    public MongoClient mongoClient() throws MongoException {
        return MongoClients.create("mongodb://localhost:27017");
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, "urlshortenerdb");
    }




}
