package com.example.demo.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String driverLicenseNumber;
}