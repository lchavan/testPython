package com.optum.ct.template.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Example for application configuration properties. Provides an externalized configuration that is made available in
 * the IoC container. Property conversions are provided by built-in Spring converters.
 *
 * The properties can be provided in various ways, using property files, YAML based configuration files with profiles
 * or system properties to name a few, see application.yaml for example.
 */
@Component
@ConfigurationProperties
public class TemplateProperties {
}
