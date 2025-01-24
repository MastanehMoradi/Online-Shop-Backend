package com.example.shop_store_back.dto;

import com.example.shop_store_back.data.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductsResponseDto {

    private List<Product> results;
    private int count;
    private String next;

}
