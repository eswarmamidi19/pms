//package com.pms.app.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.Arrays;
//
//@Configuration
//public class CorsConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        System.out.println("hello bro");
//        registry.addMapping("/**")
//                .allowedOriginPatterns("http://localhost:4200", "http://127.0.0.1:4200") // Use allowedOriginPatterns for better compatibility
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH") // Include OPTIONS and PATCH
//                .allowedHeaders("*") // Allow all headers
//                .exposedHeaders("Authorization", "Content-Type", "X-Requested-With") // Expose necessary headers
//                .allowCredentials(true) // Allow credentials
//                .maxAge(3600); // Cache preflight response for 1 hour
//    }
//
//    // Alternative Bean-based CORS configuration (more robust)
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//
//        // Allow specific origins
//        configuration.setAllowedOriginPatterns(Arrays.asList("http://localhost:4200", "http://127.0.0.1:4200"));
//
//        // Allow all headers
//        configuration.setAllowedHeaders(Arrays.asList("*"));
//
//        // Allow specific methods
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
//
//        // Expose headers that the frontend can access
//        configuration.setExposedHeaders(Arrays.asList("Authorization", "Content-Type", "X-Requested-With"));
//
//        // Allow credentials
//        configuration.setAllowCredentials(true);
//
//        // Set max age for preflight requests
//        configuration.setMaxAge(3600L);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//
//        return source;
//    }
//}

package com.pms.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // Allow Angular frontend
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));

        // Allow sending cookies & Authorization headers
        config.setAllowCredentials(true);

        // Allow all request headers
        config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "Accept", "Origin", "X-Requested-With"));

        // Allow these methods
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Expose Authorization header so Angular can read it
        config.setExposedHeaders(Arrays.asList("Authorization"));

        // Register this config for all endpoints
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}