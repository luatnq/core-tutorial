package com.example.core_authentication.constant;

public class AuthenticationConstant {
  public static class Role {
    public static final String USER = "user";
  }

  public static class PathAPI {
    public static final String USER_PATH_APIS = "/users/**";
  }

  public static class Common {
    public static String PREFIX_ROLE = "ROLE_";
    public static String REALM_ACCESS = "realm_access";
    public static String ROLES = "roles";
    public static String USERNAME = "username";
    public static String AUTHORITIES = "authorities";
  }

  public static class Token{
    public static String SID = "sid";
    public static String PREFERRED_USERNAME = "preferred_username";
  }
}
