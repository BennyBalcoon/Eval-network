package com.benoitsimplon.socialnetwork.dtos;

import org.springframework.lang.Nullable;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class UserCreateDto {

    @Size(min = 1, max = 255)
    @NotBlank
    private String firstname;

    @Size(min=1, max=255)
    @NotBlank
    private String lastname;

    @Size(min = 8, max = 20)
    @NotEmpty
    private String password;

    @Size(min = 3, max = 256)
    @NotNull
    @Email
    private String email;

    @NotNull
    @Past
    private LocalDate birthdate;

    public UserCreateDto() {
        //
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
