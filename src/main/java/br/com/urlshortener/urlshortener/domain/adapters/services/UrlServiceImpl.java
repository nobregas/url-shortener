package br.com.urlshortener.urlshortener.domain.adapters.services;

import br.com.urlshortener.urlshortener.domain.Url;
import br.com.urlshortener.urlshortener.domain.dtos.ShortUrlRequest;
import br.com.urlshortener.urlshortener.domain.dtos.ShortUrlResponse;
import br.com.urlshortener.urlshortener.domain.ports.interfaces.UrlServicePort;
import br.com.urlshortener.urlshortener.domain.ports.repositories.UrlRepositoryPort;
import br.com.urlshortener.urlshortener.infra.adapters.entities.UrlEntity;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

import org.springframework.http.HttpHeaders;

import java.net.URI;
import java.time.LocalDateTime;


@RequiredArgsConstructor
public class UrlServiceImpl implements UrlServicePort {

    private final UrlRepositoryPort urlRepository;

    @Override
    public ShortUrlResponse shortenUrl(ShortUrlRequest request, HttpServletRequest servletRequest) {

        UrlEntity urlEntity = new UrlEntity(
                request.url(), LocalDateTime.now().plusMinutes(1)
        );
        var url = urlRepository.save(urlEntity.toUrl());

        var redirectUrl = servletRequest.getRequestURL()
                .toString()
                .replace("shorten", url.getId());

        return new ShortUrlResponse(redirectUrl);
    }

    @Override
    public HttpHeaders redirect(String id) {
        Url url = urlRepository.findById(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(url.getOriginUrl()));

        return headers;
    }
}
