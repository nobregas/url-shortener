package br.com.urlshortener.urlshortener.infra.adapters.entities;

import br.com.urlshortener.urlshortener.domain.Url;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDateTime;

@Document(collection = "urls")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlEntity {
    @Id
    private String id;

    private String originUrl;

    @Indexed(expireAfterSeconds = 0)
    private LocalDateTime expiresAt;

    public UrlEntity(Url url) {
        this.originUrl = url.getOriginUrl();
        this.expiresAt = url.getExpiresAt();
    }

    public UrlEntity(String originUrl, LocalDateTime expiresAt) {
        this.originUrl = originUrl;
        this.expiresAt = expiresAt;
    }

    public Url toUrl() {
        return new Url(id, originUrl, expiresAt);
    }
}
