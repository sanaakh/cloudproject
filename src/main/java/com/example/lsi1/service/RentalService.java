package com.example.lsi1.service;

import com.example.lsi1.data.Car;
import com.example.lsi1.data.CarNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class RentalService {

    private List<Car> cars = new ArrayList<>();

    public RentalService() {
        cars.add(new Car("AA11BB", "Ferrari", 1000));
        cars.add(new Car("BB22CC", "Porsche", 2000));
        cars.add(new Car("CC44DD", "Peugeot", 400));
        cars.forEach(car -> car.setRented(false));
    }

    public List<Car> getCars() {
        return cars;
    }

    public void rent(String plateNumber) throws CarNotFoundException {
        Car carToRent = cars.stream()
                            .filter(car -> car.getPlateNumber().equals(plateNumber))
                            .findFirst()
                            .orElseThrow(() -> new CarNotFoundException("Car with plate number: " + plateNumber + " not found."));

        if (carToRent.isRented()) {
            throw new IllegalStateException("Car is already rented.");
        }

        carToRent.setRented(true);
    }

    public Car getCarByPlateNumber(String plateNumber) throws CarNotFoundException {
        return cars.stream()
                   .filter(car -> car.getPlateNumber().equals(plateNumber))
                   .findFirst()
                   .orElseThrow(() -> new CarNotFoundException("Car with plate number: " + plateNumber + " not found."));
    }
}
