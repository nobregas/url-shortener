package br.com.urlshortener.urlshortener.infra.adapters.repositories;

import br.com.urlshortener.urlshortener.infra.adapters.entities.UrlEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringUrlRepository extends MongoRepository<UrlEntity, String> {
}
