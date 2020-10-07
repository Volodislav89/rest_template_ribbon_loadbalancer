package com.spring_cloud.rest_template_ribbon_loadbalancer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private Long id;
    private String brand;
    private String model;
    private String color;
    private int year;
}