package com.br.parking.controller;

import com.br.parking.model.ParkingSpot;
import com.br.parking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parking")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @PostMapping("/spots")
    public ResponseEntity<ParkingSpot> createParkingSpot(@RequestBody ParkingSpot parkingSpot) {
        ParkingSpot createdSpot = parkingService.createParkingSpot(parkingSpot);
        return ResponseEntity.ok(createdSpot);
    }

    @GetMapping("/spots")
    public ResponseEntity<List<ParkingSpot>> getAllParkingSpots() {
        List<ParkingSpot> spots = parkingService.getAllParkingSpots();
        return ResponseEntity.ok(spots);
    }

    @GetMapping("/spots/{id}")
    public ResponseEntity<ParkingSpot> getParkingSpotById(@PathVariable Long id) {
        ParkingSpot spot = parkingService.getParkingSpotById(id);
        return ResponseEntity.ok(spot);
    }

    @PutMapping("/spots/{id}")
    public ResponseEntity<ParkingSpot> updateParkingSpot(@PathVariable Long id, @RequestBody ParkingSpot parkingSpot) {
        ParkingSpot updatedSpot = parkingService.updateParkingSpot(id, parkingSpot);
        return ResponseEntity.ok(updatedSpot);
    }

    @DeleteMapping("/spots/{id}")
    public ResponseEntity<Void> deleteParkingSpot(@PathVariable Long id) {
        parkingService.deleteParkingSpot(id);
        return ResponseEntity.noContent().build();
    }
}
