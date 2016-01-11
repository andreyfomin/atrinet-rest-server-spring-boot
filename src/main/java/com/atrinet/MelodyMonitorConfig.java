package com.atrinet;

/**
 * Created by rasth on 1/11/2016.
 */

import net.bull.javamelody.MonitoringFilter;
import net.bull.javamelody.MonitoringSpringAdvisor;
import net.bull.javamelody.Parameter;
import net.bull.javamelody.SessionListener;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSessionListener;

@Configuration
public class MelodyMonitorConfig {

    @Bean
    public HttpSessionListener onStartup() throws ServletException {
        return new SessionListener();
    }

    @Bean
    FilterRegistrationBean javaMelodyRegistrationBean() {

        FilterRegistrationBean javaMelody = new FilterRegistrationBean();

        javaMelody.setFilter(new MonitoringFilter());
        javaMelody.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.ASYNC);
        javaMelody.addInitParameter(Parameter.LOG.getCode(), Boolean.toString(true));

        return javaMelody;
    }

    @Bean
    MonitoringSpringAdvisor componentSpringAdvisor() {

        MonitoringSpringAdvisor advisor = new MonitoringSpringAdvisor();
        advisor.setPointcut(new AnnotationMatchingPointcut(Component.class));

        return advisor;
    }

    @Bean
    MonitoringSpringAdvisor serviceSpringAdvisor() {

        MonitoringSpringAdvisor advisor = new MonitoringSpringAdvisor();

        advisor.setPointcut(new AnnotationMatchingPointcut(Service.class));

        return advisor;
    }

    @Bean
    MonitoringSpringAdvisor controllerSpringAdvisor() {

        MonitoringSpringAdvisor advisor = new MonitoringSpringAdvisor();

        advisor.setPointcut(new AnnotationMatchingPointcut(RestController.class));

        return advisor;
    }
}
