package app.models;

import io.javalin.core.security.Role;
import org.eclipse.jetty.io.ArrayByteBufferPool;

public class User {
    private Long id = null;
    private String email = null;
    private String name = null;
    private String phone_number = null;
    private Role role = null;
    private String password = null;

    public User(){

    }

    public User(String email, String name, Role role) {
        this.email = email;
        this.name = name;
        this.role = role;
    }

    public User(Long id, String email, String name,  Role role, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.role = role;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
        //        ", phone_number='" + phone_number + '\'' +
                ", role=" + role + '\'' +
                ", password=" + password + '\'' +
                '}';
    }
}