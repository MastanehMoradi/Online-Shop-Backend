package com.example.shop_store_back.api;

import com.example.shop_store_back.service.ChatService;
import com.example.shop_store_back.service.ImageService;
import com.example.shop_store_back.service.RecipeService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GenAIController {

    private final ChatService chatService;
    private final ImageService imageService;
    private final RecipeService recipeService;

    public GenAIController(ChatService chatService, ImageService imageService, RecipeService recipeService) {
        this.chatService = chatService;
        this.imageService = imageService;
        this.recipeService = recipeService;
    }

    @GetMapping("ask-ai")
    public String getResponse(@RequestParam String prompt){
        return chatService.getResponse(prompt);
    }

    @GetMapping("ask-ai-options")
    public String getResponseOptions(@RequestParam String prompt){
        return chatService.getResponseOptions(prompt);
    }

    @GetMapping("generate-image")
    public void generateImage(HttpServletResponse response, @RequestParam String prompt) throws IOException {
        String imageUrl= imageService.optionalImage(prompt).getResult().getOutput().getUrl();
        response.sendRedirect(imageUrl);

        //streams to get urls from Image Response
//        return imageService.optionalImage(prompt).getResults().stream()
//                .map(resp -> resp.getOutput().getUrl())
//                .collect(Collectors.toList());

    }

    @GetMapping("recepie-creator")
    public String getRecepies(@RequestParam(defaultValue = "") String ingeridents,
                              @RequestParam(defaultValue = "any") String cuisine,
                              @RequestParam(defaultValue = "") String dietaryRestrictions){
        return recipeService.createRecipe(ingeridents,cuisine,dietaryRestrictions);
    }
}
