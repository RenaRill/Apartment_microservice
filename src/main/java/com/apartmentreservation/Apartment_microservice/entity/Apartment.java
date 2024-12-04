package com.apartmentreservation.Apartment_microservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "apartment")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class Apartment {
    @Id
    private String id;
    private String number;
    private String hotel;
    private int capacity;
    private int pricePerNight;
    private float rating;
    private String amenities;
}
