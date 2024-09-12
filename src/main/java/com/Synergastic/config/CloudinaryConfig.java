package com.Synergastic.config;



import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dmk4fps6v",
            "api_key", "278416264138921",
            "api_secret", "q8TNP0U3fgshFyEHHw6HAal9ExQ"
        ));
    }
}
