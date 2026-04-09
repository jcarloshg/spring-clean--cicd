package com.clean_archi.crud_items.userconfig;

import org.springframework.stereotype.Component;

@Component
public class AppInfo {

    private String version = "1.0.0";
    private String environment = "development";

    public String getVersion() {
        return version;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getInfo() {
        return "App v" + version + " running in " + environment;
    }
}