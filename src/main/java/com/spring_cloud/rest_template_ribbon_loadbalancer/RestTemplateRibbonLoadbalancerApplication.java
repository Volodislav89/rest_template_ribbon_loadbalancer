package com.spring_cloud.rest_template_ribbon_loadbalancer;

import com.spring_cloud.rest_template_ribbon_loadbalancer.config.RibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@RibbonClient(name = "ping-a-server", configuration = RibbonConfiguration.class)
public class RestTemplateRibbonLoadbalancerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestTemplateRibbonLoadbalancerApplication.class, args);
    }

}
