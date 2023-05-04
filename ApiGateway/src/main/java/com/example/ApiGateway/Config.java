package com.example.ApiGateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){//route information


        return routeLocatorBuilder.routes().
                //define the routes for the API Gateway
                // path() method specifies the URL path pattern for the route,
                //uri() method specifies the destination service to forward requests to.
                        route(p->p.path("/api/user/v1/**").uri("lb://UserAuthentication-server-Furniture")).
                route(p->p.path("/api/user/furniture/v1/**").uri("lb://Product-server-Furniture")).
                build();
    }

}
