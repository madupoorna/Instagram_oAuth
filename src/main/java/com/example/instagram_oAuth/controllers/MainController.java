package com.example.instagram_oAuth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
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
    public RedirectView redirectToInstagram() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(logic.buildRedirectUrl());
        return redirectView;
    }

    @GetMapping("/callbackurl")
    public void callback(@RequestParam("code") String code) throws IOException {
        System.out.println(code);
        URL url = new URL(logic.buildAccessTokenUrl());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
    }

}
