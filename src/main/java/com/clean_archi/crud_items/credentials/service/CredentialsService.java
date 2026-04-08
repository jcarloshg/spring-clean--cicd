package com.clean_archi.crud_items.credentials.service;

public interface CredentialsService {
    Object getTokenInfo(String authorization, String requestId);
    Object getUserAgent(String userAgent);
    Object getAllHeaders(String acceptLanguage, String accept, String customHeader);
}