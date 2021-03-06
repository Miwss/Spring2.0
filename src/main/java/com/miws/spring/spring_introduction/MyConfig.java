package com.miws.spring.spring_introduction;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:myApp.properties")
@ComponentScan("com.miws.spring.spring_introduction")
public class MyConfig {
}
