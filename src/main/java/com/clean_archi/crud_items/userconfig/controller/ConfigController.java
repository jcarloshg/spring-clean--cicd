package com.clean_archi.crud_items.userconfig.controller;

import com.clean_archi.crud_items.userconfig.AppInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/config")
public class ConfigController {

    private final String appName;
    private final Integer maxItems;
    private final Boolean featureEnabled;
    private final AppInfo appInfo;

    public ConfigController(
            @Qualifier("appName") String appName,
            @Qualifier("maxItems") Integer maxItems,
            @Qualifier("featureEnabled") Boolean featureEnabled,
            AppInfo appInfo) {
        this.appName = appName;
        this.maxItems = maxItems;
        this.featureEnabled = featureEnabled;
        this.appInfo = appInfo;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getConfig() {
        Map<String, Object> config = new HashMap<>();
        config.put("appName", appName);
        config.put("maxItems", maxItems);
        config.put("featureEnabled", featureEnabled);
        config.put("appInfo", appInfo.getInfo());
        return ResponseEntity.ok(config);
    }

    @GetMapping("/app-name")
    public ResponseEntity<String> getAppName() {
        return ResponseEntity.ok(appName);
    }

    @GetMapping("/max-items")
    public ResponseEntity<Integer> getMaxItems() {
        return ResponseEntity.ok(maxItems);
    }

    @GetMapping("/feature-enabled")
    public ResponseEntity<Boolean> isFeatureEnabled() {
        return ResponseEntity.ok(featureEnabled);
    }

    @GetMapping("/app-info")
    public ResponseEntity<String> getAppInfo() {
        return ResponseEntity.ok(appInfo.getInfo());
    }
}