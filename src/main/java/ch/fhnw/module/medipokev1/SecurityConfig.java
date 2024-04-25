package ch.fhnw.module.medipokev1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

                /*.securityMatcher("/api/**")
                .authorizeHttpRequests((authorize) -> authorize
                        //.requestMatchers("/", "/greeting").permitAll()
                        .requestMatchers("/nogreeting").hasRole("USER")
                        .requestMatchers("/admin").hasRole("ADMIN")
                        //.anyRequest().denyAll()
                        .anyRequest().authenticated()
                )
                */
                //TODO: when logged-in with a certain user, you cannot access pages accessible via another user type. Is this authentication hierarchy ADMIN > USER?
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/", "/greeting", "/h2-console/**").permitAll()
                        .requestMatchers("/nogreeting").hasRole("USER")
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .anyRequest().denyAll()
                        //.anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        List<UserDetails> userDetails = new ArrayList<>();
        UserDetails userDetails1 = User.withDefaultPasswordEncoder()
                .username("simpleboy")
                .password("123")
                .roles("USER")
                .build();

        UserDetails userDetails2 = User.withDefaultPasswordEncoder()
                .username("adminboy")
                .password("1234")
                .roles("ADMIN")
                .build();

        userDetails.add(userDetails1);
        userDetails.add(userDetails2);


        return new InMemoryUserDetailsManager(userDetails);
    }

}