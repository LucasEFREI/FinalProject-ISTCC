package com.univ.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Car {

	private long id;
	private String plateNumber;
	private boolean rented;
	private String model;
	private int price;
	private int numberOfDays;

	public Car(){
		super();
	}

	public Car(String plateNumber, String model, int price){
		super();
		this.plateNumber=plateNumber;
		this.rented=false;
		this.model=model;
		this.price=price;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}


	@Override
	public String toString() {
		return "Car{" +
				"id=" + id +
				", plateNumber='" + plateNumber + '\'' +
				", rented=" + rented +
				", model='" + model + '\'' +
				", price=" + price +
				", numberOfDays=" + numberOfDays +
				'}';
	}
}

