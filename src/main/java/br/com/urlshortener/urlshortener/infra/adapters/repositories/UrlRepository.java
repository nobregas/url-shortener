package br.com.urlshortener.urlshortener.infra.adapters.repositories;

import br.com.urlshortener.urlshortener.domain.Url;
import br.com.urlshortener.urlshortener.domain.ports.repositories.UrlRepositoryPort;
import br.com.urlshortener.urlshortener.infra.adapters.entities.UrlEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UrlRepository implements UrlRepositoryPort {
    private final SpringUrlRepository springUrlRepository;


    @Override
    public Url findById(String id) {
        UrlEntity urlEntity = springUrlRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Url not found"));
        return urlEntity.toUrl();
    }

    @Override
    public boolean existsById(String id) {
        boolean exists = springUrlRepository.existsById(id);
        return exists;
    }

    @Override
    public Url save(Url url) {
        UrlEntity urlEntity = new UrlEntity(url);
        return springUrlRepository.save(urlEntity).toUrl();
    }
}
