package com.dev.demo;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyCarController {
	
	private CarRepository carRepository;

	public MyCarController(CarRepository carRepository) {
		this.carRepository = carRepository;
	}
	
	@GetMapping("/cool-cars")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Car> getMyCoolCars(){
		return carRepository.findAll().stream().filter(this::isCool).collect(Collectors.toList());
	}
	
	private boolean isCool(Car car) {
		return !car.getName().equals("Yugo GV");
	}
	
}
	


