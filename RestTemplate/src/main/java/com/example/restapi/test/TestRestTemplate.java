package com.example.restapi.test;

import com.example.restapi.dto.ProductResponse1;
import com.example.restapi.dto.ProductResponse2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

//@Component
public class TestRestTemplate implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("TestRestTemplate.run");
        int id=7;
//        String URL = "https://api.restful-api.dev/objects/7";
//        String URL = "https://api.restful-api.dev/objects/{id}";
        String URL = "https://api.restful-api.dev/objects";

        RestTemplate restTemplate = new RestTemplate();

//        ProductResponse response = restTemplate.getForObject(URL, ProductResponse1.class);
//        ProductResponse response = restTemplate.getForObject(URL, ProductResponse1.class, Map.of("id",id));
//        ProductResponse response = restTemplate.getForObject(URL, ProductResponse1.class, 7);
//        ResponseEntity<ProductResponse> response = restTemplate.getForEntity(URL, ProductResponse1.class);

        ResponseEntity<ProductResponse2[]> response = restTemplate.getForEntity(URL, ProductResponse2[].class);


        System.out.println(response);
        System.out.println(response.getStatusCode());
        System.out.println(Arrays.toString(response.getBody()));
        for (ProductResponse2 p:response.getBody()){
            System.out.println(p.getData());
        }





    }
}
