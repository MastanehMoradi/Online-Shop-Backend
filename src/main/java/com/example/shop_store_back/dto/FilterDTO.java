package com.example.shop_store_back.dto;

import lombok.Data;

@Data
public class FilterDTO {
    private String name;
    private String category="";
    private String sort= "name";
    private int page;

}
