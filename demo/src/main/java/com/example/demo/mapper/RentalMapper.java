package com.example.demo.mapper;

import com.example.demo.dto.request.RentalRequest;
import com.example.demo.dto.response.RentalResponse;
import com.example.demo.entity.Car;
import com.example.demo.entity.Rental;
import com.example.demo.entity.User;
import com.example.demo.enums.RentalStatus;

public class RentalMapper {
    public static Rental mapToRental(RentalRequest rentalRequest, Car car, User user){
        Rental rental = new Rental();
        rental.setCar(car);
        rental.setUser(user);
        rental.setStartDate(rentalRequest.getStartDate());
        rental.setEndDate(rentalRequest.getEndDate());
        rental.setStatus(RentalStatus.CREATED);
        return rental;
    }

    public static RentalResponse mapToRentalResponse(Rental rental)
    {
        return RentalResponse.builder()
                .publicId(rental.getPublicId())
                .car(CarMapper.mapToCarResponse(rental.getCar()))
                .user(UserMapper.mapToUserResponse(rental.getUser()))
                .startDate(rental.getStartDate())
                .endDate(rental.getEndDate())
                .status(rental.getStatus().name())
                .build();
    }
}
