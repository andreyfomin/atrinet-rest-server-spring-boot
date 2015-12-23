package com.atrinet.domain.common;

/**
 * Created by AFomin on 7/5/2015.
 */
public enum RoleType {
    ADMIN("ADMIN"),
    USER("USER"),
    DEVELOPER("DEVELOPER"),
    TESTER("TESTER");

    private final String roleType;

    RoleType(String roleType) {
        this.roleType = roleType;
    }
}