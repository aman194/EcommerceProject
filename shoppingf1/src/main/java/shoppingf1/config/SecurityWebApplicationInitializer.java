package shoppingf1.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationInitializer
extends AbstractSecurityWebApplicationInitializer {

public SecurityWebApplicationInitializer() {
  super(LoginSecurityConfig.class);
}
}
