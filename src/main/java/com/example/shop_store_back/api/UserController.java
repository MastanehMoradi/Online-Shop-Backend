//package com.example.shop_store_back.api;
//
//
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController
//public class UserController {
//
//    @GetMapping("/user-info")
//    public Map<String, Object> getProducts(@AuthenticationPrincipal OAuth2User principal){
//
//        return principal.getAttributes();
//    }
//
//
//}
