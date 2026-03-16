package com.example.demo.dto.response;

import lombok.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private UUID publicId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String driverLicenseNumber;
}