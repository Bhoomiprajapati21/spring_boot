package com.example.CarCrud.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.CarCrud.models.Car;
import com.example.CarCrud.repositories.CarRepo;



@Controller
public class CarController {

	@Autowired
	CarRepo cars;
	
	@GetMapping("/")
	public String addCar()
	{
		return "add";
	}
	
	@PostMapping("/cars/add")
	public String addCar(Car car)
	{
		cars.save(car);
		return "redirect:/cars/display";
	}
	
	@GetMapping("/cars/display")
	public String displayCar(Model model)
	{
		List<Car> car_list= cars.findAll();
		model.addAttribute("cars", car_list);
		return "display";
	}
	
	@GetMapping("/cars/delete/{id}")
	public String deleteCar(@PathVariable("id") Integer id)
	{
		cars.deleteById(id);
		return "redirect:/cars/display";
	}
	
	@GetMapping("/cars/edit/{id}")
	public String editCar(@PathVariable("id") Integer id, Model model)
	{
		Car car = cars.findById(id).get();
		model.addAttribute("car", car);
		return "edit";
	}
	
	@PostMapping("/cars/edit")
	public String editCar(Car car)
	{
		Integer id=car.getId();
		String brand=car.getBrand();
		String model1=car.getModel1();
		String price=car.getPrice();
		Car carDB = cars.findById(id).get();
		
		carDB.setBrand(brand);
		carDB.setModel1(model1);
		carDB.setPrice(price);
		
		cars.save(carDB);
		
		return "redirect:/cars/display";
	}
}