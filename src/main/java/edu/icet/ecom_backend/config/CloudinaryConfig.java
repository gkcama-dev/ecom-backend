package edu.icet.ecom_backend.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dcqroeebm"); // ඔයාගේ Cloud Name එක
        config.put("api_key", "643963956557491");       // ඔයාගේ API Key එක
        config.put("api_secret", "ohKzk6rtX0U44v_pmclv3Axz6jE"); // ඔයාගේ API Secret එක
        return new Cloudinary(config);
    }
}
