package com.example.demo.utils;

public class Constants {

private Constants() {
// Private constructor to hide the implicit public one
}

public static final String HELLO_MSG = "Hello from OBP Account Access Consents Service v3.1.2";

// OpenAPI constants
public static final String API_INFO_TITLE = "Account Access Consents API Specification";
public static final String API_INFO_DESCRIPTION = "OpenAPIs for Account Access Consents API Specification";
public static final String API_INFO_VERSION = "v3.1.2";
public static final String API_INFO_TERMS_OF_SERVICE = "https://www.openbanking.org.uk/terms-conditions";
public static final String API_INFO_LICENSE = "open-licence";
public static final String API_INFO_LICENSE_URL = "https://www.openbanking.org.uk/open-licence";

public static final String TAG_NAME_HEALTH = "Health";
public static final String TAG_DESC_HEALTH = "Health check API";
public static final String TAG_NAME_ACCOUNT_ACCESS = "Account Access";
public static final String TAG_DESC_ACCOUNT_ACCESS = "";

public static final String API_INFO_CONTACT_NAME = "Service Desk";
public static final String API_INFO_CONTACT_URL = "";
public static final String API_INFO_CONTACT_EMAIL = "obaccadmin@cynergybank.co.uk";

// Query parameters
public static final String QUERY_PARAM_PAGE = "page";
public static final String QUERY_PARAM_PAGE_SIZE = "page-size";

// Default value
public static final Integer DEFAULT_PAGE = 1;
public static final Integer DEFAULT_PAGE_SIZE = 25;
public static final Integer MAX_PAGE_SIZE = 1000;
public static final Integer IDEMPOTENCY_KEY_SIZE = 40;
public static final Integer DEFAULT_CONSENT_VALIDITY_DAYS = 90;
public static final String TIME_STAMP_REGEX = "^(-?(?:[1-9][0-9]*)?[0-9]{4})-(1[0-2]|0[1-9])-(3[01]|0[1-9]|[12][0-9])T(2[0-3]|[01][0-9]):([0-5][0-9]):([0-5][0-9])(Z|\\+(2[0-3]|[01][0-9]):([0-5][0-9])){1}$";
public static final String ERROR_CODE_NOT_NULL = "NotNull";
public static final String ERROR_URL = "https://openbankinguk.github.io/read-write-api-site3/v3.1.2/resources-and-data-models/aisp/account-access-consents.html";
public static final String ERROR_URL_ENDPOINTS =
"https://openbankinguk.github.io/read-write-api-site3/v3.1.2/resources-and-data-models/aisp/account-access-consents.html#endpoints";
public static final String ERROR_URL_MODEL =
"https://openbankinguk.github.io/read-write-api-site3/v3.1.2/resources-and-data-models/aisp/account-access-consents.html#data-model";

// Claim constants
public static final String CLAIM_TYPE_KEY = "aut";
public static final String CLAIM_TYPE_CLIENT_CREDENTIAL_TOKEN = "APPLICATION";

// Header parameter
public static final String HEADER_X_FAPI_AUTH_DATE = "x-fapi-auth-date";
public static final String HEADER_X_FAPI_CUSTOMER_IP_ADDRESS = "x-fapi-customer-ip-address";
public static final String HEADER_X_FAPI_INTERACTION_ID = "x-fapi-interaction-id";
public static final String HEADER_X_IDEMPOTENCY_KEY = "x-idempotency-key";
public static final String HEADER_X_JWS_SIGNATURE = "x-jws-signature";
public static final String HEADER_REFERRER_POLICY = "Referrer-Policy";
public static final String HEADER_STRICT_TRANSPORT_SECURITY = "Strict-Transport-Security";
public static final String HEADER_X_CONTENT_TYPE_OPTIONS = "X-Content-Type-Options";
public static final String HEADER_CACHE_CONTROL = "Cache-Control";
public static final String HEADER_PRAGMA = "Pragma";
public static final String HEADER_EXPIRES = "Expires";

// Error messages
public static final String ERROR_MAX_PAGE_SIZE = "Maximum page size supported is " + MAX_PAGE_SIZE;
public static final String ERROR_AUTH_DATE_FORMAT = "Fapi auth date header should be compliant with RFC 7231 format";
public static final String ERROR_IDEMPOTENCY_KEY_SIZE = "Idempotency key can be maximum" + IDEMPOTENCY_KEY_SIZE + " characters in size";
public static final String ERROR_RESOURCE_NOT_FOUND = "The requested resource is not found";
public static final String ERROR_INTERNAL_ERROR = "Internal server error. Please try after sometime";
public static final String ERROR_UNKNOWN = "Some unknown error occurred. Please contact system admin";
public static final String ERROR_CREATE_CONSENT = "Unable to create Account Access Consent. Please contact system admin";
public static final String ERROR_CONSENT_NOT_FOUND = "Consent not found. Please verify the consent id";
public static final String ERROR_PERMISSIONS_EMPTY = "Permission cannot be empty or null";
public static final String ERROR_PERMISSIONS_NEITHER_ACC_BASIC_OR_DETAIL = "At least ReadAccountsBasic or ReadAccountsDetail permissions should be present";
public static final String ERROR_PERMISSIONS_TRANSACTIONS_BASIC = "At least one of ReadTransactionsCredits "
+ "or ReadTransactionsDebits permissions should be present with ReadTransactionsBasic";
public static final String ERROR_PERMISSIONS_TRANSACTIONS_DETAIL = "At least one of ReadTransactionsCredits "
+ "or ReadTransactionsDebits permissions should be present with ReadTransactionsDetail";
public static final String ERROR_PERMISSIONS_TRANSACTIONS_CREDITS = "At least one of ReadTransactionsBasic "
+ "or ReadTransactionsDetail permissions should be present with ReadTransactionsCredits";
public static final String ERROR_PERMISSIONS_TRANSACTIONS_DEBITS = "At least one of ReadTransactionsBasic "
+ "or ReadTransactionsDetail permissions should be present with ReadTransactionsDebits";
public static final String ERROR_INVALID_TOKEN = "The Authorization header token value is invalid";
public static final String ERROR_MANDATORY_DATA_MISSING = "Fields/parameters are either missing or invalid";
public static final String ERROR_CONSENT_EXPIRATION_DATE_LESS_THAN_CURRENT = "The expiration date time is before the current time stamp. "
+ "Please update the expiration date and try again";
public static final String ERROR_CONSENT_EXPIRATION_DATE = "The maximum validy of the consent can be " + DEFAULT_CONSENT_VALIDITY_DAYS
+ " days. Please update the expiration date and try again";
public static final String ERROR_CONSENT_REJECTED = "This consent has already been rejected and no longer valid. Please create a new consent and proceed";
public static final String ERROR_CONSENT_REVOKED = "This consent has already been revoked and no longer valid. Please create a new consent and proceed";
public static final String ERROR_CC_GRANT_TYPE_MISTMATCH = "Tokens having client credentials grant type are only allowed";
public static final String ERROR_DATE_FORMAT = "Please use a proper date time format compliant with the ISO 8601 date-time format";
public static final String ERROR_PERMISSION_NULL = "Permissions data is mandatory, cannot be null in the request";
public static final String ERROR_PERMISSION_DUPLICATE = "Permissions data is invalid as it has duplicate data";
public static final String ERROR_PERMISSION_INVALID = "Permissions data provided in the request is invalid - ";
public static final String ERROR_ACCESS_DENIED = "Access is denied. ";

}
