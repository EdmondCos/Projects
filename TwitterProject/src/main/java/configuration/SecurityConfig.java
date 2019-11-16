package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String SECURED_ENDPOINTS = "twitter/home" + "/**";
    private static final String[] UNSECURED_ENDPOINTS = {
            "/twitter/register",
            "/twitter"};

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(SECURED_ENDPOINTS).authenticated();
        http.authorizeRequests().antMatchers(UNSECURED_ENDPOINTS).permitAll();
        http.httpBasic();

//        sa mearga din postman
        http.csrf().disable();
    }

}
