

package com.example.demo.configuration;

import java.util.Map;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.stereotype.Component;

import com.example.demo.utils.Constants;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TokenVerificationConfiguration extends DefaultAccessTokenConverter {

@Override
public OAuth2Authentication extractAuthentication(Map<String, ?> claims) {
// If the grant type is not client credential, then throw error
if (!claims.containsKey(Constants.CLAIM_TYPE_KEY)
|| !Constants.CLAIM_TYPE_CLIENT_CREDENTIAL_TOKEN.equals(claims.get(Constants.CLAIM_TYPE_KEY))) {
log.error(Constants.ERROR_CC_GRANT_TYPE_MISTMATCH);
return null;
}

OAuth2Authentication authentication = super.extractAuthentication(claims);
return new OAuth2Authentication(authentication.getOAuth2Request(), authentication.getUserAuthentication());

}

}
