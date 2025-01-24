package com.example.shop_store_back.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity

//@EnableMethodSecurity
public class WebSecurityConfiguration {

    private static final String[] WHITE_LIST_URL = {"/api/auth/login","/oauth2/authorization/google"};
    private final JwtAuthenticationSuccessHandler successHandler;

    public WebSecurityConfiguration(JwtAuthenticationSuccessHandler successHandler) {
        this.successHandler = successHandler;
    }


    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        CorsConfigurationSource configurationSource = new CorsConfigurationSourceImpl();

        http
                .cors(cors -> cors.configurationSource(configurationSource))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers(WHITE_LIST_URL)
                        .permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                        .successHandler(successHandler)
                        .defaultSuccessUrl("http://localhost:5173", true)

                )
                .addFilter(new JwtAuthorizationFilter())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        ;




//        http
//                //.cors(AbstractHttpConfigurer::disable)
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers(WHITE_LIST_URL)
//                        .permitAll()
//                        .anyRequest().authenticated()
//                )
//
////                .formLogin(form-> form.defaultSuccessUrl("/api/v1/products/welcome", true));
//
//                .oauth2Login(oauth2 ->
//                        oauth2.defaultSuccessUrl("/welcome", true)
//                                .successHandler((request, response, authentication) -> {
//                                    // Redirect to original URL if available
//                                    RequestCache requestCache = new HttpSessionRequestCache();
//                                    var savedRequest = requestCache.getRequest(request, response);
//                                    if (savedRequest != null) {
//                                        String targetUrl = savedRequest.getRedirectUrl();
//                                        response.sendRedirect(targetUrl); // Redirect to the original URL
//                                    } else {
//                                        response.sendRedirect("/welcome"); // Fallback URL
//                                    }
//                                })
//                )
//        ;
        return http.build();
    }


//    @Bean
//    public RequestCache requestCache() {
//        return new HttpSessionRequestCache();
//    }

}
