package com.example.bookhouse.model;

import com.example.bookhouse.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    @Min(value = 4, message = "It cannot be less than 4")
    private String username;
    private String password;
    private List<Role> roleList;
}
