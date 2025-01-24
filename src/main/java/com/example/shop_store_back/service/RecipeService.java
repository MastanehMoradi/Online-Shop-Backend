package com.example.shop_store_back.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RecipeService {

    private final ChatModel chatModel;

    public RecipeService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String createRecipe(String ingeridents,
                               String cuisine,
                               String dietaryRestrictions){

        var template = """
                I want to create a recipe using the following ingeridents: {ingeridents}.
                The cuisine type I prefer is {cuisine}.
                Please consider the following dietry restrictions : {dietaryRestrictions}.
                Please provide me with a detailed recipe including title, list of ingredients
                """;

        PromptTemplate propmtTemplate = new PromptTemplate(template);
        Map <String, Object> params = Map.of(
                "ingeridents",ingeridents,
                "cuisine", cuisine,
                "dietaryRestrictions", dietaryRestrictions
        );
        Prompt prompt = propmtTemplate.create(params);
       return chatModel.call(prompt).getResult().getOutput().getContent();

    }
}
