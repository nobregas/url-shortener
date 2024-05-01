package br.com.urlshortener.urlshortener.application.adapters.controllers;

import br.com.urlshortener.urlshortener.domain.dtos.ShortUrlRequest;
import br.com.urlshortener.urlshortener.domain.dtos.ShortUrlResponse;
import br.com.urlshortener.urlshortener.domain.ports.interfaces.UrlServicePort;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UrlController {
    private final UrlServicePort urlService;

    @PostMapping("/shorten")
    public ResponseEntity<ShortUrlResponse> shortenUrl(@RequestBody ShortUrlRequest shortUrlRequest,
                                                       HttpServletRequest request) {

        var response = urlService.shortenUrl(shortUrlRequest, request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> redirect(@PathVariable String id) {
        var header = urlService.redirect(id);
        return ResponseEntity.status(HttpStatus.FOUND).headers(header).build();
    }
}
