package com.dsi.authorization.util;

/**
 * Created by sabbir on 6/15/16.
 */
public class Constants {

    public static final String AUTHORIZATION = "authorization";

    public static final int TIME_INTERVAL = 10000 * 60;

    public static final String SECRET_KEY = "MTUxMWFlMjctNWZjNS00YmVlLWJlZTMtYmRkNTY2ZWQyY2E3NDg2YTNlNDktNTA0MS00NWRjLTg3NDktNGU5NGJhY2IwN2M3";

    public static final String MESSAGE = "message";

    // Error Code
    public static final String AUTHORIZATION_SERVICE_0001 = "authenticate_service_0001";
    public static final String AUTHORIZATION_SERVICE_0001_DESCRIPTION = "Not defined.";

    public static final String AUTHORIZATION_SERVICE_0002 = "authenticate_service_0002";
    public static final String AUTHORIZATION_SERVICE_0002_DESCRIPTION = "Create failed.";

    public static final String AUTHORIZATION_SERVICE_0003 = "authenticate_service_0003";
    public static final String AUTHORIZATION_SERVICE_0003_DESCRIPTION = "Update failed.";

    public static final String AUTHORIZATION_SERVICE_0004 = "authenticate_service_0004";
    public static final String AUTHORIZATION_SERVICE_0004_DESCRIPTION = "Delete failed.";

    public static final String AUTHORIZATION_SERVICE_0005 = "authenticate_service_0005";
    public static final String AUTHORIZATION_SERVICE_0005_DESCRIPTION = "Not found.";

    public static final String AUTHORIZATION_SERVICE_0006 = "authenticate_service_0006";
    public static final String AUTHORIZATION_SERVICE_0006_DESCRIPTION = "Instance initialization failed.";

    public static final String AUTHORIZATION_SERVICE_0007 = "authenticate_service_0007";
    public static final String AUTHORIZATION_SERVICE_0007_DESCRIPTION = "Token expired.";

    public static final String AUTHORIZATION_SERVICE_0008 = "authenticate_service_0008";
    public static final String AUTHORIZATION_SERVICE_0008_DESCRIPTION = "Params are missing.";

    public static final String AUTHORIZATION_SERVICE_0009 = "authenticate_service_0009";
    public static final String AUTHORIZATION_SERVICE_0009_DESCRIPTION = "JSON read/write failed.";

    public static final String AUTHORIZATION_SERVICE_0010 = "authenticate_service_0010";
    public static final String AUTHORIZATION_SERVICE_0010_DESCRIPTION = "Not match.";
}
