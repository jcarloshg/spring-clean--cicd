package com.clean_archi.crud_items.credentials.service.impl;

import com.clean_archi.crud_items.credentials.service.CredentialsService;
import org.springframework.stereotype.Service;

@Service
public class CredentialsServiceImpl implements CredentialsService {

    @Override
    public Object getTokenInfo(String authorization, String requestId) {
        String token = authorization != null ? authorization.replace("Bearer ", "") : null;
        return "Token: " + token + ", RequestId: " + requestId;
    }

    @Override
    public Object getUserAgent(String userAgent) {
        return "User-Agent: " + userAgent;
    }

    @Override
    public Object getAllHeaders(String acceptLanguage, String accept, String customHeader) {
        return "AcceptLanguage: " + acceptLanguage + ", Accept: " + accept + ", Custom: " + customHeader;
    }
}