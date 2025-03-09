package com.example.lsi1.web;

import com.example.lsi1.data.Car;
import com.example.lsi1.data.Dates;
import com.example.lsi1.service.CarNotFoundException;
import com.example.lsi1.service.RentalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RentalWebService {

    private final RentalService rentalService;
    private final Logger logger = LoggerFactory.getLogger(RentalWebService.class);

    @Autowired
    public RentalWebService(RentalService rentalService){
        this.rentalService = rentalService;
    }

    @GetMapping("/cars")
    public List<Car> listOfCars() {
        return rentalService.getCars();
    }

    @GetMapping("/cars/{plaque}")
    public ResponseEntity<?> getCarDetails(@PathVariable("plaque") String plateNumber) {
        try {
            Car car = rentalService.getCarByPlateNumber(plateNumber);
            return ResponseEntity.ok(car);
        } catch (CarNotFoundException e) {
            logger.error("Error fetching car details: ", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found");
        }
    }

    @PutMapping("/cars/{plaque}")
    public ResponseEntity<?> rent(
            @PathVariable("plaque") String plateNumber,
            @RequestBody(required = false) Dates dates) {
        logger.info("Attempting to rent car with PlateNumber: " + plateNumber);
        if (dates != null) {
            logger.info("Requested dates: " + dates);
        }

        try {
            rentalService.rent(plateNumber);
            return ResponseEntity.ok("Car rented successfully");
        } catch (CarNotFoundException e) {
            logger.error("Error renting car: ", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found");
        } catch (IllegalStateException e) {
            logger.error("Error: Car is already rented", e);
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Car is already rented");
        }
    }
}
