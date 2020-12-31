package org.spring.cert.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping
    public String index() {
        return "Hello from jetty embedded container.";
    }
}
