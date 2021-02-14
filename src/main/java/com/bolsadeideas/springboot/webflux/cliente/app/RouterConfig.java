package com.bolsadeideas.springboot.webflux.cliente.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.bolsadeideas.springboot.webflux.cliente.app.handler.ProductoHandler;

@Configuration
public class RouterConfig {

	@Bean
	public RouterFunction<ServerResponse>rutas(ProductoHandler handler){
		return RouterFunctions.route(RequestPredicates.GET("/api/cliente"), handler::listar)
					.andRoute(RequestPredicates.GET("/api/cliente/{id}"), handler::ver)
					.andRoute(RequestPredicates.POST("/api/cliente"), handler::crear)
					.andRoute(RequestPredicates.PUT("/api/cliente/{id}"), handler::editar)
					.andRoute(RequestPredicates.DELETE("/api/cliente/{id}"), handler::eliminar)
					.andRoute(RequestPredicates.POST("/api/cliente/upload/{id}"), handler::upload);
	}
}
