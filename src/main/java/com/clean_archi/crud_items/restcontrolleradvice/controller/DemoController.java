package com.clean_archi.crud_items.restcontrolleradvice.controller;

import com.clean_archi.crud_items.restcontrolleradvice.service.DemoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable Long id) {
        String result = demoService.getById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/process")
    public ResponseEntity<String> processItem(@RequestBody String name) {
        String result = demoService.processItem(name);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validateItem(@RequestBody String name) {
        demoService.validateItem(name);
        return ResponseEntity.ok("Valid item: " + name);
    }
}