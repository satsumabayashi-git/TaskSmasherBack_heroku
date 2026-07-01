package com.example.TaskSmasher.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.DefaultCookieSerializer;

@Configuration
public class CookieConfig {

    @Bean
    public DefaultCookieSerializer cookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
//        serializer.setCookieName("_ctkn");
        serializer.setSameSite("None"); 
        serializer.setUseSecureCookie(true); 
        
        return serializer;
    }
}