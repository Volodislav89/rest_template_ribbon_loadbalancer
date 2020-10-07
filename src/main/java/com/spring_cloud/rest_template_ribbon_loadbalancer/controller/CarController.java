package com.spring_cloud.rest_template_ribbon_loadbalancer.controller;

import com.spring_cloud.rest_template_ribbon_loadbalancer.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
public class CarController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<Car> stringList() {
        String uri = "http://ping-server/car";
        List<Car> carList = Arrays.asList(restTemplate.getForObject(uri, Car[].class));
        return carList;
    }

    @GetMapping("/id/{id}")
    public Car findCar(@PathVariable Long id) {
        String uri = "https://ping-server/car/id/" + id;
        Car car = restTemplate.getForObject(uri, Car.class);
        return car;
    }

    @PostMapping
    public Car saveCar(@RequestBody Car car) {
        String uri = "https://ping-server/car";
        Car newCar = restTemplate.postForObject(uri, car, Car.class);
        return newCar;
    }

    @PutMapping("update/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car car) {
        String uri = "https://ping-server/car/update/" + id;
        HttpEntity<Car> httpEntity = new HttpEntity<>(car, null);
        ResponseEntity<Car> response = restTemplate.exchange(uri, HttpMethod.PUT, httpEntity, Car.class);
        return  response.getBody();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCarById(@PathVariable Long id) {
        String uri = "https://ping-server/car/delete/" + id;
        HttpEntity<String> httpEntity = new HttpEntity<>(null, null);
        ResponseEntity<Void> responseEntity = restTemplate.exchange(uri, HttpMethod.DELETE, httpEntity, Void.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return "Deleted";
        } else
            return "Not deleted";
    }
}
