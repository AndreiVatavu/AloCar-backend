package com.alocar.backend.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Andrei Vatavu on 4/24/2019
 */

@Configuration
@ComponentScan({ "com.alocar.backend.service" })
public class ServiceConfig {

}
