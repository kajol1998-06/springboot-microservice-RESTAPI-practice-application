package com.example.microservice.Rest;

import java.util.*;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice.bindingclass.Country;

@RestController
public class CountryRestController {

	private HashOperations<String, Integer,Country> ops=null;
	public CountryRestController(RedisTemplate<String,Country> rt)
	{
		this.ops=rt.opsForHash();
	}
	
	@PostMapping("/country")
	public String setcountry(@RequestBody Country con)
	{
		ops.put("Country", con.getSno(), con);
		return "country added";
	}
	
	@GetMapping("/getCountry")
	public Collection<Country> getCountry()
	{
		Map<Integer,Country> m=ops.entries("Country");
		Collection<Country> c=m.values();
		return c;
	}
}
