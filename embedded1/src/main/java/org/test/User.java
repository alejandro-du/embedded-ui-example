package org.test;

import org.apache.bval.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author Alejandro Duarte
 */
public class User {

    private static Long nextId = 1l; // just for testing ;)

    @NotNull
    private Long id;

    @NotNull
    private String name;

    @Past
    private Date birthDate;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    private Boolean active = true;

    public User() {
        this.id = nextId++;
    }

    public User(String name, Date birthDate, String email, String password, Boolean active) {
        this();
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
