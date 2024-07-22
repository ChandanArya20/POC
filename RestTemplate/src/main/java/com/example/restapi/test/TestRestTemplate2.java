package com.example.restapi.test;

import com.example.restapi.dto.ProductResponse1;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TestRestTemplate2 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("TestRestTemplate.run");

        RestTemplate restTemplate = new RestTemplate();
        String URL = "https://api.restful-api.dev/objects";
        String obj = """
                {
                   "name": "Apple MacBook Pro 16",
                   "data": {
                      "year": 2019,
                      "price": 1849.99,
                      "CPU model": "Intel Core i9",
                      "Hard disk size": "1 TB"
                   }
                }
                """;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(obj, headers);

        ResponseEntity<ProductResponse1> response = restTemplate.postForEntity(URL, requestEntity, ProductResponse1.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());

    }
}
