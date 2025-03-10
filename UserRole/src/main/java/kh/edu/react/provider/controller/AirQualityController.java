package kh.edu.react.provider.controller;

import kh.edu.react.provider.service.AirQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/air-quality")
public class AirQualityController {

    @Autowired
    private AirQualityService airQualityService;


    // Service 방식이 아닌 webconfig 사용할 때 사용방법
    // public Mono<String> getForeCast(@RequestParam String date){
    @GetMapping("forecast")
    public String getForeCast(@RequestParam(name="searchDate") String searchDate){
        return airQualityService.getAirQuality(searchDate);
    }
}
