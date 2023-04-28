package com.calpyte.user.config;

import com.calpyte.user.dto.RegistrationResponse;
import com.calpyte.user.entity.User;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;


@Service
public class KeycloakToken {

    public static final String APPLICATION_X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";
    public static final String POST = "POST";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String ACCESS_TOKEN = "access_token";
    public static final String REFRESH_TOKEN = "refresh_token";

    @Value("${keycloak.auth-server-url}")
    private String authServerUrl;

    @Value("${keycloak.resource}")
    private String clientId;

    @Value("${keycloak.credentials.secret}")
    private String secret;

    @Value("${token.url}")
    private String tokenUrl;

    public RegistrationResponse getUserToken(User user) throws IOException {
        RegistrationResponse registrationResponse = new RegistrationResponse();
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        StringBuilder requestBuilder = new StringBuilder();
        requestBuilder.append("grant_type=password&client_id=");
        requestBuilder.append(clientId);
        requestBuilder.append("&client_secret=");
        requestBuilder.append(secret);
        requestBuilder.append("&username=");
        requestBuilder.append(user.getUserName());
        requestBuilder.append("&password=");
        requestBuilder.append(user.getPassword().trim());
        requestBuilder.append("&scope=openid offline_access");

        MediaType mediaType = MediaType.parse(APPLICATION_X_WWW_FORM_URLENCODED);
        RequestBody body = RequestBody.create(requestBuilder.toString(), mediaType);
        Request request = new Request.Builder()
                .url(tokenUrl)
                .method(POST, body)
                .addHeader(CONTENT_TYPE, APPLICATION_X_WWW_FORM_URLENCODED)
                .build();
        Response response = client.newCall(request).execute();
        if(response.isSuccessful()) {
            String responseStr = response.body().string();
            JsonObject jsonObject = new JsonParser().parse(responseStr).getAsJsonObject();
            registrationResponse.setAuth(jsonObject.get(ACCESS_TOKEN).getAsString());
            registrationResponse.setToken(jsonObject.get(REFRESH_TOKEN).getAsString());
            response.close();
        }
        return  registrationResponse;
    }

    public RegistrationResponse getRefreshToken(String refreshToken) throws IOException {
        RegistrationResponse registrationResponse = new RegistrationResponse();
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse(APPLICATION_X_WWW_FORM_URLENCODED);

        StringBuilder requestBuilder = new StringBuilder();
        requestBuilder.append("grant_type=refresh_token&client_id=");
        requestBuilder.append(clientId);
        requestBuilder.append("&client_secret=");
        requestBuilder.append(secret);
        requestBuilder.append("&scope=openid offline_access");
        requestBuilder.append("&refresh_token=");
        requestBuilder.append(refreshToken);

        RequestBody body = RequestBody.create(mediaType, requestBuilder.toString());
        Request request = new Request.Builder()
                .url(tokenUrl)
                .method(POST, body)
                .addHeader(CONTENT_TYPE, APPLICATION_X_WWW_FORM_URLENCODED)
                .build();

        Response response = client.newCall(request).execute();
        String responseStr = response.body().string();
        try{
            if(response.isSuccessful()) {
                JsonObject jsonObject = new JsonParser().parse(responseStr).getAsJsonObject();
                registrationResponse.setAuth(jsonObject.get(ACCESS_TOKEN).getAsString());
                registrationResponse.setToken(jsonObject.get(REFRESH_TOKEN).getAsString());
            }
        }finally {
            response.close();
        }
        return  registrationResponse;
    }

}
