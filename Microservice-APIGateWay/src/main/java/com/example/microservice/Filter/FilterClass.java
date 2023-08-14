package com.example.microservice.Filter;

import java.util.Set;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

public class FilterClass implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// TODO Auto-generated method stub
		System.out.println("filter execute");
		ServerHttpRequest request= exchange.getRequest();
		HttpHeaders header=request.getHeaders();
		Set<String> key=header.keySet();
		
		for(String k: key)
		{
			System.out.println(k+"--");
			System.out.println(header.getValuesAsList(k));
		}
		return chain.filter(exchange);
	}

}
