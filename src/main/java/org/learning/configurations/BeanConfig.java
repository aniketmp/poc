package org.learning.configurations;

import com.azure.identity.ClientSecretCredentialBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

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
       return new ClientSecretCredentialBuilder()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .tenantId(tenantId);
    }
    @Bean
    @Profile("debug")
    public Object showServicePrincipalCredentials(){
        System.out.println("------------------Debugging is enabled------------------");
        System.out.println();
        System.out.println("keyVaultUrl:"+keyVaultUrl);
        System.out.println("clientId:"+clientId);
        System.out.println("clientSecret:"+clientSecret);
        System.out.println("tenantId:"+tenantId);
        System.out.println();
        System.out.println("--------------------------------------------------------");
        return null;
    }

}
