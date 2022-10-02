package com.be.ecommerce.constants;

public class Constants {
    public static final String BEARER = "Bearer ";
    public static final String TOKEN_INVALID = "Invalid JWT token: {}";
    public static final String TOKEN_EXPIRED = "JWT token is expired: {}";
    public static final String TOKEN_UNSUPPORTED = "JWT token is unsupported: {}";
    public static final String TOKEN_ARGUMENT = "JWT claims string is empty: {}";
    public static final String TOKEN_NOT_FOUND = "TOKEN NOT FOUND";
    public static final String AUTHORITIES = "authorities";
    public static final String USER_NOT_FOUND = "THERE IS NO USER WITH ID: ";
    public static final String PRODUCT_NOT_FOUND = "THERE IS NO PRODUCT WITH ID: ";
    public static final String USER_EXISTS = "THERE IS ALREADY A USER WITH THE EMAIL: ";
    public static final String COMA = ",";
    public static final String SLASH = "/";
    public static final Integer TIME_EXPIRATION = 600000;
}

