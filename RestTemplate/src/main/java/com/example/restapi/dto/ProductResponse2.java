package com.example.restapi.dto;

import lombok.Data;

@Data
public class ProductResponse2 {

    private String id;
    private String name;
    private ProductData2 data;

    @Data
    public static class ProductData2 {
        private String color;
        private String capacity;
    }
}
