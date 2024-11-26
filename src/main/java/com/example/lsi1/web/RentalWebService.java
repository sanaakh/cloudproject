package com.example.lsi1.web;

import com.example.lsi1.data.Car;
import com.example.lsi1.data.Dates;
import com.example.lsi1.service.RentalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RentalWebService {

    RentalService rentalService;
    Logger logger = LoggerFactory.getLogger(RentalWebService.class);

    @Autowired
    public RentalWebService(RentalService rentalService){
        this.rentalService = rentalService;
    }

    @GetMapping("/cars")
    public List<Car> listOfCars(){
        return rentalService.getCars();
    }

    @PutMapping(value = "/cars/{plaque}")
    public void rent(
            @PathVariable("plaque") String plateNumber,
            @RequestParam(value="rent", required = true)boolean rent,
            @RequestBody Dates dates){

        logger.info("PlateNumber: " + plateNumber);
        logger.info("Rent: " + rent);
        logger.info("Dates: " + dates);

        rentalService.rent(plateNumber);

    }

}
