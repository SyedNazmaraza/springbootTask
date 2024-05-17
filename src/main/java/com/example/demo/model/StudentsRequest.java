package com.example.demo.model;

import com.example.demo.entity.Guardian;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentsRequest {
    @NotNull(message = "Invalid Name")
    private String firstName;
    @NotNull(message = "Invalid Name")
    private String lastName;
    @Email(message = "Invalid email")
    private String emailId;
    private Guardian guardian;
}
