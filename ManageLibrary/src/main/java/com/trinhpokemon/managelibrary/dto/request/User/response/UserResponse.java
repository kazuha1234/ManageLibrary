package com.trinhpokemon.managelibrary.dto.request.User.response;

import com.trinhpokemon.managelibrary.enums.Gender;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private String id;
    private String name;
    private Date dob;
    private Gender gender;
    private String address;
    private String email;
    private String phone;
    private String username;
    private String role;
}
