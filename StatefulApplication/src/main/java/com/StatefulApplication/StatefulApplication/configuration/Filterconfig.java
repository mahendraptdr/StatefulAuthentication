package com.StatefulApplication.StatefulApplication.configuration;

import com.StatefulApplication.StatefulApplication.Filter.Myfilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class Filterconfig {
    public FilterRegistrationBean<Myfilter> filterconfig()
    {
        FilterRegistrationBean<Myfilter>  registration = new FilterRegistrationBean<>();
        registration.setFilter(new Myfilter());
        registration.addUrlPatterns("/login","/home","/veryfication","/useresgister");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public InternalResourceViewResolver viewResolver()
    {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

}


