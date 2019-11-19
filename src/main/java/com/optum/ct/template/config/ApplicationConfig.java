package com.optum.ct.template.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Example service configuration class. A configuration provides a factory for container managed beans.
 * Can be used to configure beans that are not annotated with javax.inject or Spring annotations.
 */
@Configuration
public class ApplicationConfig {

    @Bean
    public Object configureAServiceBean() {
        return new Object();
    }
}
