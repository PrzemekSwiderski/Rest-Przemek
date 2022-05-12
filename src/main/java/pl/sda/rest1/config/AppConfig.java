package pl.sda.rest1.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@Getter
public class AppConfig {

    @Value("${api.key}")
    private String apiKey;

    @Value("${api.baseUrl}")
    private String baseUrl;


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
