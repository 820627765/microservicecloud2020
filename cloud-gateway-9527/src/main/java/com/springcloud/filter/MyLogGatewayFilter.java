package com.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("**** my log message ****");
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (uname == null) {
            log.info("**** 用户名为null，非法用户 ****");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            //表示响应给调用方了
            return exchange.getResponse().setComplete();
        }
        //继续下一个过滤器
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        // 数字越小，优先级越高
        return 0;
    }
}