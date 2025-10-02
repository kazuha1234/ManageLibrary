package com.trinhpokemon.managelibrary.dto.request.User.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trinhpokemon.managelibrary.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserUpdateRequest {
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    private Gender gender;
    private String address;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String role;
}
