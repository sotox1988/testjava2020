package com.example.testjava.matias.people.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
    private String clientid = "tutorialspoint";
    private String clientSecret = "my-secret-key";
    private String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEogIBAAKCAQEA1OH6NJ/6tCwtBcZjzi22L7/TC3bZ3JHfdBKGmYo7OZOkf9Qt" +
            "TJYaWeEZj1sG0KhXVgXjgebbSpEZ5wB9EQjdTuVQJDgBRMcrWrHFxQtK9tZiqz5P" +
            "o83PPf4i9ERdvv00GrBElRjs5Sevk1fgg8aZ1fJZfLkFX0XJy514goxk6eBqamRu" +
            "rc/mKU8VJ5Fnb89mR57ZozsN00Kg3mRRvSIPo/XGAo+yKYIgmIo1KHA8xzwxyNZw" +
            "UAGYFRFINtBqTx+n4MbNgcRMHWpchz1J8GVGQR6WWHj1nAvuVvN12kUN3Tzb8igq" +
            "pZNVTY5mc3i3rcvixMhgVKgI6J7Nvp2mzEFJfQIDAQABAoIBAEpN8gJKULxwqupY" +
            "G+AMTooOH4Dh5Bs8A03FZZvUBuYK5aEEkycnQV1b14sVD6TnDUzmU0m1JZe6W9so" +
            "bX7zpCN0oOtzbOXvyu8mG8yyK2FK5Te2UR/wp0SRHuw5rKsMQBKMsfOEtrMpjfwU" +
            "8TWtrWZi599DyV8+wbfDaBvRGywSWItWgVm0qBq10/DktIhIF+b6Pjg9I9ulvDSo" +
            "jQHWP1n7Q0y+Evc8vfkAn+5URX5RC6akd+gGwECnAo04UyKESDmawNtfP1+dYRJa" +
            "RSZsVE3sWU7u3/fXLjImX1cv4g/C9F6x3LeNBfyiphPAk8z6eVOis/ZYJC18UEcP" +
            "ePJkSJUCgYEA9NjCNCKLQBNeGVmfdKq19bG/GayUozvLsapM/h715z0rqzUk5QkO" +
            "woOfozM2/E1EiJqfM8t0iqJz6BLwxlnLwFqjpAROdLNCzrbSdsZQROlJZeTMM6XQ" +
            "Jm/GPqvKfT2nmrehAnLWVSxEc9VjXILbMa4U9gZ2lxbddZTI6f/I1j8CgYEA3pR5" +
            "yXcXGjxT/x7Ftzis+Nlx+P0dVWXV/pwEDxyhfvxXsX4cnHmR5RiL+KCDxsPS3UeB" +
            "tUQSH+ilYADVzKPq+mHsNTS3SnCgNd1zhqoVEHLOvZII3762R6t/nH1f55J9NAyb" +
            "jdgAomsTrz3dZ6PHwwymmDYheuNxcQPW6JSXCUMCgYBJ668mIk+8NpywNpinlmp9" +
            "FP7G942ggosKxomcJyjCeXtXoyHSbBuiqi5mDS5KmeFZBKWP85rpyAYKSL2chLu5" +
            "BSRmfk5ZeU1wL033QgQ16eCY/KyR4zumfxRxE1h820JguZPIs3b2G/lGp2PqKC+Z" +
            "Hh+B742aK/MMbrEBxJGT7QKBgFlfTuOJURp0vNmEtqkSNcoaLbxnjf67TEjWxn52" +
            "5ZXCp0eatsxRuDZAO/vSH/eQq7u0Oa3aLljnpne8/hwUeYaeCSV4DFz0ii/2wquA" +
            "4cJgBwlxeOS2hCSVBUGFyhuG44UhxtgWsnKFAjtsYNl7lvuHueEGYz0f1G4nt4Re" +
            "HaNXAoGAQy1+8leRCw2jFyXPE4gmyp3/1ABJ6KzSglAPl9ek5vpuIzNtK23U6nkn" +
            "6lPDVinuiNQC6XFdVHVmdsGeK//aPn5zkP8f/lzMqRhDQxLxxkyPawcPvCrTwKBY" +
            "npEgAB8TI1dDGozVp4i1rcpCAUqPRI6Kd+eLJXqX5i+PBP3R/6s=" +
            "\n-----END RSA PRIVATE KEY-----\n";

    private String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1OH6NJ/6tCwtBcZjzi22" +
            "L7/TC3bZ3JHfdBKGmYo7OZOkf9QtTJYaWeEZj1sG0KhXVgXjgebbSpEZ5wB9EQjd" +
            "TuVQJDgBRMcrWrHFxQtK9tZiqz5Po83PPf4i9ERdvv00GrBElRjs5Sevk1fgg8aZ" +
            "1fJZfLkFX0XJy514goxk6eBqamRurc/mKU8VJ5Fnb89mR57ZozsN00Kg3mRRvSIP" +
            "o/XGAo+yKYIgmIo1KHA8xzwxyNZwUAGYFRFINtBqTx+n4MbNgcRMHWpchz1J8GVG" +
            "QR6WWHj1nAvuVvN12kUN3Tzb8igqpZNVTY5mc3i3rcvixMhgVKgI6J7Nvp2mzEFJ" +
            "fQIDAQAB" +
            "\n-----END PUBLIC KEY-----\n";

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Bean
    public JwtAccessTokenConverter tokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(privateKey);
        converter.setVerifierKey(publicKey);
        return converter;
    }

    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(tokenEnhancer());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
                .accessTokenConverter(tokenEnhancer());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient(clientid).secret(clientSecret).scopes("read", "write")
                .authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(20000)
                .refreshTokenValiditySeconds(20000);

    }
}