package com.michaelskree.movieservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieServiceController {

    @GetMapping("/")
    public void index() {
    }
}
