package com.example.instagram_oAuth.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Logic {

    @Value("${instagram.client.id}")
    private String clientId;

    @Value("${instagram.callbackUrl}")
    private String callbackUrl;

    @Value("${instagram.secret}")
    private String clientSecret;

    public Logic() {
    }

    public String buildRedirectUrl(){
        return "https://api.instagram.com/oauth/authorize/?client_id="+clientId+"&redirect_uri="+callbackUrl+"&response_type=code&scope=basic&state";
    }

    public String buildAccessTokenUrl(){
        return "https://api.instagram.com/oauth/access_token?client_id="+clientId+"&client_secret="+clientSecret+"&grant_type=authorization_code&redirect_uri="+callbackUrl+"&code=CODE";
    }

}
