package com.calpyte.user.service.impl;

import com.calpyte.user.config.KeycloakToken;
import com.calpyte.user.dto.RegistrationResponse;
import com.calpyte.user.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;

import com.calpyte.user.entity.User;
//import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private KeycloakToken keycloakToken;

    @Override
    public Map<String, String> getToken(String token) throws IOException {
        String authToken = keycloakToken.getRefreshToken(token).getAuth();
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", authToken);
        return tokenMap;
    }

    @Override
    public RegistrationResponse getAccessToken(User user) throws IOException {
        RegistrationResponse authToken = keycloakToken.getUserToken(user);
        return authToken;
    }
}
