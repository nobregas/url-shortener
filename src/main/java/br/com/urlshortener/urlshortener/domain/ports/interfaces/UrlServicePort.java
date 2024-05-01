package br.com.urlshortener.urlshortener.domain.ports.interfaces;

import br.com.urlshortener.urlshortener.domain.dtos.ShortUrlRequest;
import br.com.urlshortener.urlshortener.domain.dtos.ShortUrlResponse;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;

public interface UrlServicePort {
    ShortUrlResponse shortenUrl(ShortUrlRequest request, HttpServletRequest servletMapping);
    HttpHeaders redirect(String id);

}