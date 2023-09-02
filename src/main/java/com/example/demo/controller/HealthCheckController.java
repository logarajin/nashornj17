

package com.example.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.utils.Constants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Tag(name = "HEALTH")
public class HealthCheckController {

/**
 * GET : /health - Service to test if server is up and running.
 *
 * @return  The hello message from server
 */
@PreAuthorize("hasAuthority('SCOPE_accounts')")	
@Operation(description = "Service to check Account Access Service is up and running or not",
operationId = "testServer",
summary = "API Service to check Account Access is up and running or not",
responses =  @ApiResponse(content = { @Content(
        schema = @Schema(implementation = String.class)) }), tags = { "Hello" })
@GetMapping("/health")
public ResponseEntity<String> testServer(@Parameter(description= "An Authorisation Token as per https://tools.ietf.org/html/rfc6750", required = true)
@RequestHeader(value = HttpHeaders.AUTHORIZATION, required = true) String authorization) {
log.debug("Hello --1->>> "+authorization);
log.info("Hello -2-->>> "+authorization);
System.out.println("Hello --3->>> "+authorization);
return new ResponseEntity<>(Constants.HELLO_MSG, HttpStatus.OK);
}

}