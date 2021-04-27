package app.models;

public enum Role implements io.javalin.core.security.Role {
    ADMIN,
    REGISTERED,
    ANONYMOUS
}
