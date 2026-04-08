package com.clean_archi.crud_items;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/info")
public class HelloController {

    @GetMapping("/helloword")
    public String hello() {
        return "Hello World!";
    }
}
