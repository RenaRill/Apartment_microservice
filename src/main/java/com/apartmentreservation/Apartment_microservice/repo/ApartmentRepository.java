package com.apartmentreservation.Apartment_microservice.repo;

import com.apartmentreservation.Apartment_microservice.entity.Apartment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApartmentRepository extends MongoRepository<Apartment, String> {
}
