package org.learning.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "config")
public class AppConfig {
    private String appName;
    private String appVersion;
    private String keyVaultUri;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getKeyVaultUri() {
        return keyVaultUri;
    }

    public void setKeyVaultUri(String keyVaultUri) {
        this.keyVaultUri = keyVaultUri;
    }

    @Override
    public String toString() {
        return "AppConfig{" +
                "appName='" + appName + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", keyVaultUri='" + keyVaultUri + '\'' +
                '}';
    }
}
