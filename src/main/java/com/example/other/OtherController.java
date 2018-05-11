package com.example.other;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("other")
public class OtherController {
	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}
}
