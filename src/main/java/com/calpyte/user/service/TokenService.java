package com.calpyte.user.service;

import com.calpyte.user.dto.RegistrationResponse;
import com.calpyte.user.entity.User;

import java.io.IOException;
import java.util.Map;

public interface TokenService {


    Map<String, String> getToken(String token) throws IOException;

    RegistrationResponse getAccessToken(User user) throws IOException;
}
