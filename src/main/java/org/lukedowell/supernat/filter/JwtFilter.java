package org.lukedowell.supernat.filter;

import org.lukedowell.supernat.services.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by ldowell on 11/30/15.
 */
public class JwtFilter extends GenericFilterBean {

    private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);

    private final JwtService jwtService;

    public JwtFilter(JwtService service) {
        logger.debug("JwtFilter - jwtService: {}", service);
        this.jwtService = service;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.debug("doFilter - request: {} response: {} filterChain: {}", request, response, chain);


        Authentication auth = jwtService.getAuthentication((HttpServletRequest) request);
        logger.debug("doFilter - auth: {}", auth);

        if(auth != null) {
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        chain.doFilter(request, response);

        if(auth != null) {
            SecurityContextHolder.getContext().setAuthentication(null);
        }
    }

}
