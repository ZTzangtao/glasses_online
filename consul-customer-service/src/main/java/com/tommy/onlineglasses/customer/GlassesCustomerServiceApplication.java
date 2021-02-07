package com.tommy.onlineglasses.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zangtao
 */
@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
public class GlassesCustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlassesCustomerServiceApplication.class, args);
	}

//	@Bean
////	public HttpComponentsClientHttpRequestFactory requestFactory() {
////		PoolingHttpClientConnectionManager connectionManager =
////				new PoolingHttpClientConnectionManager(30, TimeUnit.SECONDS);
////		connectionManager.setMaxTotal(200);
////		connectionManager.setDefaultMaxPerRoute(20);
////
////		CloseableHttpClient httpClient = HttpClients.custom()
////				.setConnectionManager(connectionManager)
////				.evictIdleConnections(30, TimeUnit.SECONDS)
////				.disableAutomaticRetries()
////				// 有 Keep-Alive 认里面的值，没有的话永久有效
////				//.setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE)
////				// 换成自定义的
////				.setKeepAliveStrategy(new CustomConnectionKeepAliveStrategy())
////				.build();
////
////		HttpComponentsClientHttpRequestFactory requestFactory =
////				new HttpComponentsClientHttpRequestFactory(httpClient);
////
////		return requestFactory;
////	}

//	@LoadBalanced
//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//		return builder
//				.setConnectTimeout(Duration.ofMillis(100))
//				.setReadTimeout(Duration.ofMillis(500))
//				.requestFactory(this::requestFactory)
//				.build();
//	}
}
