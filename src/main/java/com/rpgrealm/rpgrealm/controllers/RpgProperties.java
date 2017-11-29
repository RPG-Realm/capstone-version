package com.rpgrealm.rpgrealm.controllers;

import org.springframework.stereotype.Component;

@Component("rpgRealm-maps")
public class RpgProperties {

    public String maps = "AIzaSyA_aW46paw93bYNfkDyd-w6IUiXYTn9mzk";

    public String getMaps() {
        return maps;
    }

    public void setMaps(String maps) {
        this.maps = maps;
    }
}