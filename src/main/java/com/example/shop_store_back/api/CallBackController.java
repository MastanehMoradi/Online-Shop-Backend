package com.example.shop_store_back.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//
@RestController
public class CallBackController {



    @GetMapping("welcome")
    public String getResponse(){
        return "Hello";
    }

}
