package com.example.restapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductData1 {

    private int year;
    private double price;
    @JsonProperty("CPU model")
    private String cpuModel;
    @JsonProperty("Hard disk size")
    private String hardDiskSize;

}