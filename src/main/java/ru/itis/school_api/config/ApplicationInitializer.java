package ru.itis.school_api.config;

import lombok.SneakyThrows;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class ApplicationInitializer implements WebApplicationInitializer {
    @SneakyThrows
    @Override
    public void onStartup(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
        ContextLoaderListener listener = new ContextLoaderListener(springContext);
        servletContext.addListener(listener);
        springContext.register(AppConfiguration.class);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(springContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
