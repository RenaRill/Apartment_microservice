package com.apartmentreservation.Apartment_microservice.controller;

import com.apartmentreservation.Apartment_microservice.entity.Apartment;
import com.apartmentreservation.Apartment_microservice.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apartment")
@RequiredArgsConstructor
public class ApartmentController {

    private final ApartmentService apartmentService;

    @PostMapping
    public ResponseEntity<Apartment> createApartment(@RequestBody Apartment apartment) {
        Apartment savedApartment = apartmentService.save(apartment);
        return ResponseEntity.ok(savedApartment);
    }

    @GetMapping
    public ResponseEntity<List<Apartment>> getAllApartments() {
        List<Apartment> apartments = apartmentService.findAll();
        return ResponseEntity.ok(apartments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apartment> getApartment(@PathVariable String id) {
        Apartment apartment = apartmentService.findById(id);
        if (apartment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(apartment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApartment(@PathVariable String id) {
        apartmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{apartmentId}/price")
    public ResponseEntity<Integer> getPricePerNight(@PathVariable String apartmentId) {
        Apartment apartment = apartmentService.findById(apartmentId);
        if (apartment != null) {
            return ResponseEntity.ok(apartment.getPricePerNight());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

