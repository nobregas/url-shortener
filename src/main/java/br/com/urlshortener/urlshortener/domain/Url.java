package br.com.urlshortener.urlshortener.domain;

import java.time.LocalDateTime;

public class Url {
    private String id;
    private String originUrl;
    private LocalDateTime expiresAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginUrl() {
        return originUrl;
    }

    public void setOriginUrl(String originUrl) {
        this.originUrl = originUrl;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Url(String id, String originUrl, LocalDateTime expiresAt) {
        this.id = id;
        this.originUrl = originUrl;
        this.expiresAt = expiresAt;
    }

    public Url() {
    }
}
