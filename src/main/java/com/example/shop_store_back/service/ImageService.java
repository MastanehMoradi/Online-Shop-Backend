package com.example.shop_store_back.service;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private final OpenAiImageModel openaiImageModel;

    public ImageService(OpenAiImageModel imageModel) {
        this.openaiImageModel = imageModel;
    }

    public ImageResponse optionalImage(String prompt){

      //https://docs.spring.io/spring-ai/reference/api/image/openai-image.html
        //https://platform.openai.com/docs/api-reference/images
        return openaiImageModel.call(
                new ImagePrompt(prompt,
                        OpenAiImageOptions.builder()
                                .withModel("dall-e-2")
                                .withQuality("hd")
                                .withN(3)
                                .withHeight(1024)
                                .withWidth(1024).build())

        );
    }
}
