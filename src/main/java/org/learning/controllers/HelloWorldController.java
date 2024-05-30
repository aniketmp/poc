package org.learning.controllers;

import org.learning.configurations.AppConfig;
import org.learning.services.AzureKeyVaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloWorldController {
    @Autowired
    private AzureKeyVaultService azureKeyVaultService;
    private final String  SECRET_KEY="secret-message";

    @Autowired
    private  AppConfig properties;

    public HelloWorldController(AppConfig properties) {
        this.properties = properties;
    }

    @GetMapping
    public ResponseEntity<?> getMessage() throws Exception {
        return ResponseEntity.ok("Service principal: Hello world from POC!");
    }
    @GetMapping("/secret-message")
    public ResponseEntity<?> getMessageFromAzureKeyVault() throws Exception {
        String secretValue=azureKeyVaultService.getSecret(SECRET_KEY);
        return ResponseEntity.ok(secretValue);
    }
    @GetMapping("/properties")
    public ResponseEntity<?> getAppConfigProperties() throws Exception {
        return ResponseEntity.ok(properties);
    }
  }
