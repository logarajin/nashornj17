package com.example.demo.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.utils.Constants;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

/**
 *
 * @implNote Configuration class for Open API Specifications
 */
@Configuration
public class OpenApiConfiguration {

    static final String SECURITY_SCHEME_NAME = "Bearer oAuth Token";

    /**
     * Open API Configuration Bean
     *
     * @param title
     * @param version
     * @param description
     * @return
     */
    @Bean
    public OpenAPI apiConfiguration() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .components(
                        new Components()
                                .addSecuritySchemes(SECURITY_SCHEME_NAME,
                                        new SecurityScheme()
                                                .name(SECURITY_SCHEME_NAME)
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                )
                )
               
                .info(new Info()
                        .title(Constants.API_INFO_TITLE)
                        .version(Constants.API_INFO_VERSION)
                        .description(Constants.API_INFO_DESCRIPTION)
                        .termsOfService(Constants.API_INFO_TERMS_OF_SERVICE)
                        .license(getLicense())
                        .contact(getContact())
                );
    }

    /**
     * Contact details
     *
     * @return
     */
    private Contact getContact() {
        Contact contact = new Contact();
        contact.setEmail(Constants.API_INFO_CONTACT_EMAIL);
        contact.setName(Constants.API_INFO_CONTACT_NAME);
        contact.setUrl(Constants.API_INFO_CONTACT_URL);
        contact.setExtensions(Collections.emptyMap());
        return contact;
    }

    /**
     * License creation
     *
     * @return
     */
    private License getLicense() {
        License license = new License();
        license.setName(Constants.API_INFO_LICENSE);
        license.setUrl(Constants.API_INFO_LICENSE_URL);
        license.setExtensions(Collections.emptyMap());
        return license;
    }

}


