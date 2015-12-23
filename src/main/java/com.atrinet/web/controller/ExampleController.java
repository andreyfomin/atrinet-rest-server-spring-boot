package com.atrinet.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by AFomin on 7/5/2015.
 */
@RestController
public class ExampleController {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
}