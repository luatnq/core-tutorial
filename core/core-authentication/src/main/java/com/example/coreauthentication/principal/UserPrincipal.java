package com.example.coreauthentication.principal;

import com.example.coreauthentication.constant.AuthenticationConstant;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class UserPrincipal {

  public static Map<String, Object> getPrincipalInfo(JwtAuthenticationToken principal) {
    Collection<String> authorities = principal.getAuthorities()
        .stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.toList());

    Map<String, Object> info = new HashMap<>();
    info.put(AuthenticationConstant.Token.SID, principal.getTokenAttributes().get(AuthenticationConstant.Token.SID));
    info.put(AuthenticationConstant.Common.USERNAME, principal.getTokenAttributes().get(AuthenticationConstant.Token.PREFERRED_USERNAME));
    info.put(AuthenticationConstant.Common.AUTHORITIES, authorities);
    info.put(AuthenticationConstant.Common.UID, principal.getToken().getSubject());
    return info;
  }

  public static String getUserID(){
    return SecurityContextHolder.getContext().getAuthentication().getName();
  }
}
