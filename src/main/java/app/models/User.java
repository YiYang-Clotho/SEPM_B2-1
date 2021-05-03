package app.models;

import io.javalin.core.security.Role;

public class User {
    private Long id = null;
    private String email = null;
    private String name = null;
    private Role role = null;
    private String password = null;
    private String phone = null;
    private int age = 0;

    public User(){

    }

    public User(String email, String name, Role role) {
        this.email = email;
        this.name = name;
        this.role = role;
    }

    public User(String email, String name, int age, String password, String phone) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.password = password;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String num) {
        this.phone = phone;
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


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", role=" + role + '\'' +
                ", password=" + password + '\'' +
                ", phone=" + phone + '\'' +
                '}';
    }
}
