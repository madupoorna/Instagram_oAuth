package com.example.instagram_oAuth.controllers;

import com.example.instagram_oAuth.models.Response;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class MainController {

    @Autowired
    Logic logic;

    @GetMapping("/")
    public ModelAndView loginPageRequest() {
        return new ModelAndView("login");
    }

    @GetMapping("/redirect")
    public RedirectView redirectToInstagram() throws UnsupportedEncodingException {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(logic.buildRedirectUrl());
        return redirectView;
    }

    @GetMapping("/callbackurl")
    public ModelAndView callback(@RequestParam("code") String code) throws IOException {

        ModelAndView modelAndView;

        URL url = new URL(logic.accessTokenUrl());
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("POST");
        urlConnection.setDoInput(true);
        urlConnection.setDoOutput(true);

        OutputStreamWriter writer = new OutputStreamWriter(urlConnection.getOutputStream());
        writer.write(logic.buildAccessTokenQueryUrl(code));
        writer.flush();

        Gson g = new Gson();
        Response response = g.fromJson(logic.getJsonResponse(urlConnection.getInputStream()), Response.class);

        modelAndView = new ModelAndView("home.html");
        modelAndView.addObject("userName", response.getUser().getUsername());
        modelAndView.addObject("profileUrl", response.getUser().getProfile_picture());
        modelAndView.addObject("bio", response.getUser().getBio());

        return modelAndView;
    }

}
