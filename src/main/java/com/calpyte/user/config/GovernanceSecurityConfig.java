package com.calpyte.user.config;

import com.keycloak.connector.security.IAMKeycloakSecurityConfig;
import org.keycloak.adapters.springsecurity.client.KeycloakClientRequestFactory;

import org.springframework.security.config.annotation.web.builders.WebSecurity;

//
//@Configuration
//@Order(1)
public class GovernanceSecurityConfig extends IAMKeycloakSecurityConfig {

    private static final String RESOURCES = "/resources/**";
    private static final String SWAGGER_UI_HTML = "/swagger-ui.html";
    private static final String SWAGGER_UI = "/swagger-ui/**";
    private static final String API_DOCS = "/api-docs/**";

    public GovernanceSecurityConfig(KeycloakClientRequestFactory keycloakClientRequestFactory) {
        super(keycloakClientRequestFactory);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(RESOURCES, SWAGGER_UI_HTML, SWAGGER_UI, API_DOCS,
                "/otp/send-otp", "/user/by-mobile", "/user/login", "/user/save","user/**",
                "/unsecure/token", "/users/save-device", "/users/signin", "/file/save", "/unsecure/**",
                "/department/", "/office/save", "/officer/save","/location/","/location/**","/designation/get-all","/office/**", "/officer/**"
        );

    }
}
