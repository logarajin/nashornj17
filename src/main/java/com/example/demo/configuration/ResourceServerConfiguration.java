package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.server.resource.introspection.NimbusOpaqueTokenIntrospector;
import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class ResourceServerConfiguration {

@Value("${security.oauth2.client.client-id}")
private String clientId;

@Value("${security.oauth2.client.client-secret}")
private String clientSecret;

@Value("${security.oauth2.resource.token-info-uri}")
private String tokenInfoUri;

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

http
.authorizeRequests((authorize) -> authorize
    .requestMatchers(new RequestHeaderRequestMatcher(HttpHeaders.AUTHORIZATION))    
    .fullyAuthenticated())
    .oauth2ResourceServer(oauth2 -> oauth2
                .opaqueToken(opaqueToken -> opaqueToken
                    .introspector(myCustomIntrospector())
                )
            );
return http.build();
}


@Bean
public OpaqueTokenIntrospector myCustomIntrospector() {
    return new NimbusOpaqueTokenIntrospector(tokenInfoUri, clientId, clientSecret);
}


@Bean
public AccessTokenConverter accessTokenConverter() {
return new TokenVerificationConfiguration();
}

/**
 * Method to create a bean for resource server token services.
 *
 * @return the ResourceServerTokenServices bean
 */
@Primary
@Bean
public ResourceServerTokenServices resourceServerTokenServices() {
RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
remoteTokenServices.setCheckTokenEndpointUrl(tokenInfoUri);
remoteTokenServices.setClientId(clientId);
remoteTokenServices.setClientSecret(clientSecret);
remoteTokenServices.setAccessTokenConverter(accessTokenConverter());

return remoteTokenServices;
}


}