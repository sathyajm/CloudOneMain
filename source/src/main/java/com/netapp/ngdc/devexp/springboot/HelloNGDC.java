package com.netapp.ngdc.devexp.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloNGDC {

    @GetMapping("/")
    public String index() {
        return "NGDC Demo App - v10";
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

}
