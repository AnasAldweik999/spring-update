package com.example.demo.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.demo.security.ApplicationUserPermessions.*;

public enum ApplicationUserRoles {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(STUDENT_READ, STUDENT_WRITE, COURSE_READ, COURSE_WRITE)),

    ADMINTRAINEE(Sets.newHashSet(COURSE_READ, STUDENT_READ));


    private final Set<ApplicationUserPermessions> persmesions;

    ApplicationUserRoles(Set<ApplicationUserPermessions> persmesions) {
        this.persmesions = persmesions;
    }


    public Set<ApplicationUserPermessions> getPersmesions() {
        return persmesions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPersmesions().stream().
                map(permission -> new SimpleGrantedAuthority(permission.getPersmession())).collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return permissions;
    }
}
