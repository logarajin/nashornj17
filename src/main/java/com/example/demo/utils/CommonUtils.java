package com.example.demo.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.util.UriComponentsBuilder;
import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class CommonUtils {

@Autowired
private Tracer autoWiredTracer;
private static Tracer tracer;

@PostConstruct
private void init() {
tracer = this.autoWiredTracer; //NOSONAR
}

private CommonUtils() {
// Private constructor to hide the implicit public one
}

private static String getUri(HttpServletRequest request, String gatewayHostUrl) {
StringBuilder uri = new StringBuilder();
uri.append(request.getScheme())
.append("://")
.append(gatewayHostUrl)
.append(request.getRequestURI());

if (StringUtils.hasText(request.getQueryString())) {
uri.append("?")
.append(request.getQueryString());
}

return uri.toString();
}

private static String getFirstPageLink(String uri, int pageSize) {
UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(uri)
.replaceQueryParam(Constants.QUERY_PARAM_PAGE, 1)
.replaceQueryParam(Constants.QUERY_PARAM_PAGE_SIZE, pageSize);

return uriComponentsBuilder.toUriString();
}

private static String getLastPageLink(String uri, int pageSize, int totalPages) {
UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(uri)
.replaceQueryParam(Constants.QUERY_PARAM_PAGE, totalPages)
.replaceQueryParam(Constants.QUERY_PARAM_PAGE_SIZE, pageSize);

return uriComponentsBuilder.toUriString();
}

private static String getNextPageLink(String uri, int pageSize, int totalPages, int currentPage) {
int nextPage = currentPage < totalPages
? currentPage + 1 : totalPages;

UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(uri)
.replaceQueryParam(Constants.QUERY_PARAM_PAGE, nextPage)
.replaceQueryParam(Constants.QUERY_PARAM_PAGE_SIZE, pageSize);

return uriComponentsBuilder.toUriString();
}

private static String getPreviousPageLink(String uri, int pageSize, int totalPages, int currentPage) {
int previousPage = 0;
if (currentPage == totalPages) {
if (totalPages == 1) {
previousPage = currentPage;
} else {
previousPage = currentPage - 1;
}
} else {
if (currentPage == 1) {
previousPage = 1;
} else {
previousPage = currentPage - 1;
}
}

UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(uri)
.replaceQueryParam(Constants.QUERY_PARAM_PAGE, previousPage)
.replaceQueryParam(Constants.QUERY_PARAM_PAGE_SIZE, pageSize);

return uriComponentsBuilder.toUriString();
}

private static String getSelfPageLink(String uri, int currentPage, int pageSize) {
UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(uri)
.replaceQueryParam(Constants.QUERY_PARAM_PAGE, currentPage)
.replaceQueryParam(Constants.QUERY_PARAM_PAGE_SIZE, pageSize);

return uriComponentsBuilder.toUriString();
}

/**
 * Method to get the decoded value.
 *
 * @param encodedValue  The encoded string value
 * @return the decoded string value
 */
public static String getDecodedValue(String encodedValue) {
try {
if (!StringUtils.hasText(encodedValue)) {
return null;
} else {
return URLDecoder.decode(encodedValue, StandardCharsets.UTF_8.name());
}
} catch (UnsupportedEncodingException e) {

}
return encodedValue;
}

/**
 * Method to get the error id.
 *
 * @return the error id
 */
public static String getErrorId() {
if (null != tracer) {
Span span = tracer.currentSpan();
if (null != span) {
String traceId = span.context().traceId();
if (StringUtils.hasText(traceId)) {
return traceId;
}
}
}
return UUID.randomUUID().toString();
}

}
