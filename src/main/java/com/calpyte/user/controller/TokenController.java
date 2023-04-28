package com.calpyte.user.controller;

import com.calpyte.user.dto.RegistrationResponse;

import com.calpyte.user.entity.User;
import com.calpyte.user.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/unsecure")
public class TokenController {


    @Autowired
    private TokenService tokenService;

    @RequestMapping(value = "/token",method = RequestMethod.POST)
    private ResponseEntity<?> getTokenByRefresh(@RequestBody Map<String, String> tokenMap) throws IOException {
        return new ResponseEntity<>(tokenService.getToken(tokenMap.get("token")), HttpStatus.OK);
    }

    @RequestMapping(value = "/access/token",method = RequestMethod.POST)
    private ResponseEntity<RegistrationResponse> getAccessToken(@RequestBody User user) throws IOException {
        return new ResponseEntity<>(tokenService.getAccessToken(user), HttpStatus.OK);
    }

}
