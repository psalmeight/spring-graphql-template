package co.accessthreads.gobeyond.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SecurityUtils {

    static List<String> getRoles() {

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        if (authentication == null)
            return Collections.emptyList();

        ArrayList<String> roles = new ArrayList<>();

        for (GrantedAuthority authority : authentication.getAuthorities()) {
            roles.add(authority.getAuthority());
        }

        return roles;
    }

    static String currentLogin() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        if (authentication == null)
            return "system";

        User springSecurityUser;
        String userName = null;

        if (authentication.getPrincipal().getClass() == User.class) {
            springSecurityUser = ((User) authentication.getPrincipal());
            userName = springSecurityUser.getUsername();
        } else if (authentication.getPrincipal().getClass() == String.class) {
            userName = ((String) authentication.getPrincipal());
        }

        return userName;
    }
}
