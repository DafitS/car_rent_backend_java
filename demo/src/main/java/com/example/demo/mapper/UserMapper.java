package com.example.demo.mapper;

import com.example.demo.dto.request.UserRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.entity.User;

public class UserMapper {

    public static User mapToUser(UserRequest userRequest){
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhoneNumber());
        user.setDriverLicenseNumber(userRequest.getDriverLicenseNumber());
        return user;
    }

    public static UserResponse mapToUserResponse(User user){
        return UserResponse.builder()
                .publicId(user.getPublicId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phoneNumber(user.getPhone())
                .driverLicenseNumber(user.getDriverLicenseNumber())
                .build();
    }
}
