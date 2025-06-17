package com.simplilearn.cabproapi.service;


import com.simplilearn.cabproapi.model.GeoCode;
import com.simplilearn.cabproapi.model.GeoProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Optional;


@Service
@Slf4j
public class GeoCodeServiceImpl implements GeoCodeService {

    private final WebClient webClient;

    @Value("${geoKey}")
    private String geoKey;

    public GeoCodeServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }


    public Optional<GeoProperties> getGeoCode(String address) {
        GeoCode response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                    .path("/search")
                    .queryParam("text", address)
                    .queryParam("apiKey", geoKey)
                    .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(GeoCode.class)
                .block();
        try {
            if (response != null && response.getFeatures() != null && !response.getFeatures().isEmpty()) {
                return Optional.ofNullable(response.getFeatures().getFirst().getProperties());
            } else {
                log.warn("No geocoding results found for address {}", address);
                return Optional.empty();
            }

        } catch (Exception e) {
            log.error("Geoapify lookup failed: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }
}
