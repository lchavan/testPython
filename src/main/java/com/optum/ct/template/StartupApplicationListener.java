package com.optum.ct.template;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StartupApplicationListener implements
        ApplicationListener<ContextRefreshedEvent> {
        protected static final Logger logger = LoggerFactory.getLogger(StartupApplicationListener.class);


        @Override public void onApplicationEvent(ContextRefreshedEvent event) {

                ApplicationContext context = event.getApplicationContext();
                logger.info("Datasource: " + context.getEnvironment().getProperty("spring.datasource.url"));

                String gitInfo = null;
                try {
                        gitInfo = MiscUtils.readFromInputStream(StartupApplicationListener.class.getResourceAsStream("/git.properties"));
                        logger.info(gitInfo);
                } catch (IOException e) {
                        logger.warn("Could not read the git properties file");
                }

        }
}
