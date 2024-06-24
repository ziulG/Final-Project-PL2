package com.br.parking.service;

import com.br.parking.model.ParkingSpot;
import com.br.parking.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;

    public ParkingSpot createParkingSpot(ParkingSpot parkingSpot) {
        return parkingRepository.save(parkingSpot);
    }

    public List<ParkingSpot> getAllParkingSpots() {
        return parkingRepository.findAll();
    }

    public ParkingSpot getParkingSpotById(Long id) {
        Optional<ParkingSpot> parkingSpot = parkingRepository.findById(id);
        return parkingSpot.orElse(null);
    }

    public ParkingSpot updateParkingSpot(Long id, ParkingSpot parkingSpotDetails) {
        ParkingSpot parkingSpot = getParkingSpotById(id);
        if (parkingSpot != null) {
            parkingSpot.setNumber(parkingSpotDetails.getNumber());
            parkingSpot.setLocation(parkingSpotDetails.getLocation());
            parkingSpot.setStatus(parkingSpotDetails.getStatus());
            parkingSpot.setVehicleType(parkingSpotDetails.getVehicleType());
            return parkingRepository.save(parkingSpot);
        } else {
            return null;
        }
    }

    public void deleteParkingSpot(Long id) {
        parkingRepository.deleteById(id);
    }
}
