package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value="classpath:global.properties", encoding="UTF-8")
public class GlobalProperties {
    @Value("${images.path}")
    private String imagesPath;

    public String getImagesPath() {
        return imagesPath;
    }


}
