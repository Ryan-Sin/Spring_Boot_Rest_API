package com.ryan.spring_boot_rest_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ryan
 * @description @Bean Methods in @Configuration Classes
 */
@Configuration
public class BeanInConfiguration {

    @Bean
    public Parents getParents() {
       return new Parents();
    }

    @Bean
    public void SystemOutPrint1(){
        Parents parents = getParents();
        System.out.println("SystemOutPrint1 parents = " + parents);
    }

    @Bean
    public void SystemOutPrint2(){
        Parents parents = getParents();
        System.out.println("SystemOutPrint2 parents = " + parents);
    }
}
