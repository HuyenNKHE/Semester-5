package vn.titv.spring.FirstAPI.sercurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserConfiguration {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails tung = User.withUsername("an").password("{noop}123456").roles("teacher").build();

        UserDetails quoc = User.withUsername("quoc").password("{noop}123").roles("manager").build();

        UserDetails kiet = User.withUsername("kiet").password("{noop}kiet456").roles("admin").build();

        return new InMemoryUserDetailsManager(tung, quoc, kiet);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                configurer->configurer
                        .requestMatchers(HttpMethod.GET, "api/students").hasAnyRole("teacher", "manager", "admin")
                        .requestMatchers(HttpMethod.GET, "api/students/**").hasAnyRole("teacher", "manager", "admin")
                        .requestMatchers(HttpMethod.POST, "api/students").hasAnyRole("manager", "admin")
                        .requestMatchers(HttpMethod.PUT, "api/students/**").hasAnyRole("manager", "admin")
                        .requestMatchers(HttpMethod.DELETE, "api/students/**").hasRole("admin")
        );
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(csrf->csrf.disable());

        return httpSecurity.build();
    }
}

