package beans.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class ServletsConfiguration {

    @Bean
    public ServletRegistrationBean<CustomServlet> myServletRegistration() {
        // mandatory specify the mapping URL
        ServletRegistrationBean<CustomServlet> bean = new ServletRegistrationBean<>(
                new CustomServlet(), "/customServletURL");
        bean.setLoadOnStartup(1);
        return bean;
    }

    @Bean
    public ServletRegistrationBean<CustomServletGet> myServletRegistrationGet() {
        // mandatory specify the mapping URL
        ServletRegistrationBean<CustomServletGet> bean = new ServletRegistrationBean<>
                (new CustomServletGet(), "/customServletGetURL");
        bean.setLoadOnStartup(1);
        return bean;
    }

    @Bean
    public ServletRegistrationBean<CustomServletPost> myServletRegistrationPost() {
        // mandatory specify the mapping URL
        ServletRegistrationBean<CustomServletPost> bean = new ServletRegistrationBean<>
                (new CustomServletPost(), "/customServletPostURL");
        bean.setLoadOnStartup(1);
        return bean;
    }

    @Bean
    FilterRegistrationBean myFilterRegistration() {
        FilterRegistrationBean<CustomFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new CustomFilter());
        bean.setUrlPatterns(Collections.singletonList("/customServletURL/*"));
        return bean;
    }

}
