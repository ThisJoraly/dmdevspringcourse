package com.dmdev.logging.config;

import javax.annotation.PostConstruct;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Slf4j
@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "app.common.logging")
public class LoggingProperties {
    /**
     * to enable common logging aop to a service layer
     */
    private boolean enabled;
    private String level;

    @PostConstruct
    void init() {
        log.info("Logging props initialized: {}", this);
    }
}
