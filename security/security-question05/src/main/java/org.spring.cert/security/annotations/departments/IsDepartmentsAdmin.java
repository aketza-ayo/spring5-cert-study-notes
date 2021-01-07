package org.spring.cert.security.annotations.departments;

import org.springframework.security.access.annotation.Secured;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.spring.cert.security.SecurityRoles.DEPARTMENTS_ADMIN;
import static org.spring.cert.security.SecurityRoles.ROLE_PREFIX;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Secured(ROLE_PREFIX + DEPARTMENTS_ADMIN)
public @interface IsDepartmentsAdmin {
}
