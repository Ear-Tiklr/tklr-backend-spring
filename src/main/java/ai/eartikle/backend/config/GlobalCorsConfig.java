package ai.eartikle.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class GlobalCorsConfig {

    @Value("${spring.cors.allowed:{http://localhost:3000,https://eartiklr.com}}")
    private List<String> allowedOrigins;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOriginPatterns("http://localhost:3000", "https://tiklr-next-custom-player.vercel.app", "https://tiklr-next-custom-player.vercel.com", "https://tiklr-next-custom-player-36nh6risa-eartiklr.vercel.app/", "https://tiklr-next-custom-player.*" , "*") // Replace with your actual allowed origins
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true)
                        .maxAge(3600);
            }
        };
    }
}