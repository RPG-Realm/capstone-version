package com.rpgrealm.rpgrealm.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

  @Configuration
  @EnableWebMvc
  public class WebAppConfig extends WebMvcConfigurerAdapter {

    // This controller extends the webMVC built into spring and overrides the "/" to point to our /home instead of static/index.html

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
      registry.addRedirectViewController("/", "/home");
    }

  }


