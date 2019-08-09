package ro.creativewool.notificationservice.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
@ConfigurationProperties("mail.smtp")

public class EmailProperties {

    private Boolean auth;
    private Boolean starttlsEnable;
    private String host;
    private String port;
    private Boolean sslTrust;

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAuth() {
        return auth;
    }

    public void setAuth(Boolean auth) {
        this.auth = auth;
    }

    public boolean isStarttlsEnable() {
        return starttlsEnable;
    }

    public void setStarttlsEnable(boolean starttlsEnable) {
        this.starttlsEnable = starttlsEnable;
    }

    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public boolean isSslTrust() {
        return sslTrust;
    }
    public void setSslTrust(boolean sslTrust) {
        this.sslTrust = sslTrust;
    }

    public Properties toProperties() {

        Properties prop = new Properties();

        prop.put("mail.smtp.auth", this.auth);
        prop.put("mail.smtp.starttls.enable", this.starttlsEnable);
        prop.put("mail.smtp.host", this.host);
        prop.put("mail.smtp.port", this.port);
        prop.put("mail.smtp.ssl.trust", this.sslTrust);

        return prop;
    }
}