package com.apartmentreservation.Apartment_microservice.service;

import com.apartmentreservation.Apartment_microservice.entity.Apartment;
import com.apartmentreservation.Apartment_microservice.repo.ApartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApartmentService {

    @Autowired
    private final ApartmentRepository apartmentRepository;


    public Apartment save(Apartment apartment) {
        return apartmentRepository.save(apartment);
    }

    public List<Apartment> findAll() {
        return apartmentRepository.findAll();
    }

    public Apartment findById(String id) {
        return apartmentRepository.findById(id).orElse(null);
    }

    public void delete(String id) {
        apartmentRepository.deleteById(id);
    }
}

