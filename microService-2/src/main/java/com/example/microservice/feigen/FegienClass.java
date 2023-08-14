package com.example.microservice.feigen;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "GREETING-APPLICATION")
public interface FegienClass {

	@GetMapping("/greet")
	public String getotherAPI();
}
