package com.example.restapi.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ProductResponse1 {

    private String id;
    private String name;
    private ProductData1 data;
    private String createdAt;

}

