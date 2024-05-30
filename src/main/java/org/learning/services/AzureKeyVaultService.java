package org.learning.services;

import com.azure.identity.ClientSecretCredentialBuilder;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import org.learning.configurations.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AzureKeyVaultService {
    @Autowired
    private ClientSecretCredentialBuilder builder;
    @Autowired
    private AppConfig properties;

    public ClientSecretCredentialBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(ClientSecretCredentialBuilder builder) {
        this.builder = builder;
    }
    public String getSecret(String secretKey) {
        // Authenticate with Azure
        SecretClient secretClient = new SecretClientBuilder()
                .vaultUrl(properties.getKeyVaultUri())
                .credential(builder.build())
                .buildClient();

        // Access secrets
        return secretClient.getSecret(secretKey).getValue();
    }
}
