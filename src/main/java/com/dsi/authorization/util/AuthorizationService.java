package com.dsi.authorization.util;

import com.dsi.authorization.filter.AccessTokenFilter;
import com.dsi.authorization.filter.ResponseCORSFilter;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by sabbir on 6/16/16.
 */
public class AuthorizationService extends ResourceConfig {

    public AuthorizationService(){
        packages("com.dsi.authorization");
        register(ResponseCORSFilter.class);
        //register(AccessTokenFilter.class);

        SessionUtil.getSession();
    }
}
