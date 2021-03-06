package com.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        //这个对象就相当于是yml配置中的：spring.cloud.gateway.routes:  # 这里就是配置路由的，可以配置多个路由
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        /**
         * 新增一个路由
         * 参数1：路由id
         * 参数2：是一个函数参数，配置断言 和 目标服务器的uri
         * 如下案例：表示访问 http://网关ip:网关端口/网关上下文根/guonei 将转发到 http://news.baidu.com/guonei
         */
        routes.route("my_route", //指定路由id
                r -> r.path("/guonei"). //相当于Path断言，断言匹配的是 /guonei 请求
                        uri("http://news.baidu.com/guonei") //指定，满足断言后，将要访问的地址
        ).build();

        return routes.build();
    }
}
