package org.learning.configurations;

import com.azure.identity.ClientSecretCredentialBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Value("${KEY_VAULT_URI}")
    String keyVaultUrl ;
    @Value("${AZURE_CLIENT_ID}")
    String clientId;
    @Value("${AZURE_CLIENT_SECRET}")
    String clientSecret;
    @Value("${AZURE_TENANT_ID}")
    String tenantId;//
    @Bean
    public ClientSecretCredentialBuilder getClientSecretCredentialBuilder(){
        System.out.println("keyVaultUrl:"+keyVaultUrl);
        System.out.println("clientId:"+clientId);
        System.out.println("clientSecret:"+clientSecret);
        System.out.println("tenantId:"+tenantId);
       return new ClientSecretCredentialBuilder()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .tenantId(tenantId);
    }
}
