package com.ryan.spring_boot_rest_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author Ryan
 * @description @Bean Lite Mode
 */
@Component
public class BeanInComponent {

    @Bean
    public Child getChild(){
        return new Child();
    }

    @Bean
    public void SystemOutPrint3(){
        Child child = getChild();
        System.out.println("SystemOutPrint3 child = " + child);
    }

    @Bean
    public void SystemOutPrint4(){
        Child child = getChild();
        System.out.println("SystemOutPrint4 child = " + child);
    }
}
