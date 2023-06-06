package com.tourism.agency.webApi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dasboard")
public class TestSecurityController {

	@GetMapping
	public ResponseEntity<String> say(){
		return ResponseEntity.ok("Welcome Spring Security");
	}
}
