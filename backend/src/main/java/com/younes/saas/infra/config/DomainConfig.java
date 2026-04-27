
package com.younes.saas.infra.config;

import com.younes.saas.application.annotations.Query;
import com.younes.saas.application.annotations.Command;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "com.younes.saas.application.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Query.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Command.class)
        }
)
public class DomainConfig {
}