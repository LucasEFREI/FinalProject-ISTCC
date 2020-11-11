package com.univ.web;

import com.univ.model.Car;
import com.univ.service.CarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarRentalController {

	private List<Car> cars = new ArrayList<>();
	@Autowired
	CarRentalService carRentalService;


	public CarRentalController(CarRentalService carRentalService){
		super();
		this.carRentalService = carRentalService;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/cars")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Iterable<Car> listOfCars(){
		carRentalService.sendMsg("GET");
		return carRentalService.carRepository.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/cars/{plateNumber}/rent")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void rent(@PathVariable(name="plateNumber") String plateNumber, @RequestParam(name="louer", required=true) boolean louer) {
		for (Car car: listOfCars())
		{
			if (car.getPlateNumber().equals(plateNumber))
			{
				car.setRented(louer);
				carRentalService.save(car);
			}
		}
		carRentalService.sendMsg("PUT");
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/cars/{plateNumber}/getback")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void getBack(@PathVariable(name="plateNumber") String plateNumber, @RequestParam(name="louer", required=false) boolean louer) {
		for (Car car: listOfCars())
		{
			if (car.getPlateNumber().equals(plateNumber))
			{
				car.setRented(louer);
				carRentalService.save(car);
			}
		}
		carRentalService.sendMsg("PUT");
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("cars")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void addCar(){
		System.out.println("test2");
		Car car = new Car(carRentalService.generatePlateNumber(), "Unknown", 100);
		carRentalService.save(car);
		carRentalService.sendMsg("POST");
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("cars/{plateNumber}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void deleteCar(@PathVariable(name="plateNumber") String plateNumber){
		System.out.println("test");
		for (Car car: listOfCars()) {
			if (car.getPlateNumber().equals(plateNumber)) {
				carRentalService.remove(car);
			}
		}
		carRentalService.sendMsg("DELETE");
	}


}
