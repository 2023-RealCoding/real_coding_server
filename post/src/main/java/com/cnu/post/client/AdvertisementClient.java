package com.cnu.post.client;

import com.cnu.post.model.Advertisement;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AdvertisementClient {
    RestTemplate restTemplate = new RestTemplate();
    private static final Advertisement AD_FALLBACK = new Advertisement(
            "Devblog로 개발 블로그를 만들어보자",
            "Devblog는 개발자들을 위한 블로그 플랫폼입니다. Devblog로 개발 블로그를 만들어보세요!",
            "https://devblog.com/images/og-image.png",
            "https://devblog.com"
    );
    @CircuitBreaker(name = "ad", fallbackMethod = "fallback")
    public Advertisement getAd() {
        return restTemplate.getForObject(
                "http://localhost:9090/ads",
                Advertisement.class
        );
    }

    private Advertisement fallback(CallNotPermittedException e){
        return AD_FALLBACK;
    }
}