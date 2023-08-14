package com.example.microservice.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.microservice.bindingclass.Country;

@Configuration
public class REdisConfiguration {
	
	@Bean
	public JedisConnectionFactory jediscon()
	{
		JedisConnectionFactory jedis=new JedisConnectionFactory();
		return jedis;
	}
	
	@Bean
	public RedisTemplate<String,Country> redisTemplate()
	{
		RedisTemplate<String,Country> redistem=new RedisTemplate();
		redistem.setConnectionFactory(jediscon());
		return redistem;
	}

}
