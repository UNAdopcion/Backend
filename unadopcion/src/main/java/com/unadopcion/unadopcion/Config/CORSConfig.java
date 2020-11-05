package com.unadopcion.unadopcion.Config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;
import static org.springframework.http.HttpMethod.*;


@Configuration
public class CORSConfig
{

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilte( ){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource( );
        CorsConfiguration config = new CorsConfiguration( );

        config.addAllowedOrigin( "*" );
        config.addAllowedHeader( "*" );
        config.addAllowedMethod( GET );
        config.addAllowedMethod( POST );
        config.addAllowedMethod( PATCH );
        config.addAllowedMethod( PUT );
        config.addAllowedMethod( DELETE );
        source.registerCorsConfiguration( "/**", config );

        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>( new CorsFilter(  source ) );
        bean.setOrder( HIGHEST_PRECEDENCE );

        return bean;
    }

}