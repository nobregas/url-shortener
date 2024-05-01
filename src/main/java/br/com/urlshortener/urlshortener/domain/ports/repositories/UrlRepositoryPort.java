package br.com.urlshortener.urlshortener.domain.ports.repositories;

import br.com.urlshortener.urlshortener.domain.Url;

public interface UrlRepositoryPort {
    Url findById(String id);

    boolean existsById(String id);

    Url save(Url url);

}
