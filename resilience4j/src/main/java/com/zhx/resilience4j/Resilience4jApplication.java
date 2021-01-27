package com.zhx.resilience4j;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootApplication
public class Resilience4jApplication {

  public static void main(String[] args) {
    SpringApplication.run(Resilience4jApplication.class, args);
  }

  @Bean
  public Customizer<Resilience4JCircuitBreakerFactory> circuitBreakerFactory() {
    return factory -> factory.configureDefault( id -> new Resilience4JConfigBuilder(id)
        .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(3)).build())
        .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
        .build()
    );
  }

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplateBuilder().build();
  }
}
