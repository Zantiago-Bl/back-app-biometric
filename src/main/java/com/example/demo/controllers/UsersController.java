package com.example.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Users;
import com.example.demo.services.UsersService;

@RestController
@RequestMapping("/test")
public class UsersController {
	
	@Autowired
	public UsersService usersService;
	
	@GetMapping("/getUsers")
	@CrossOrigin(origins = "*")
	public List<Users> getUsers (){
		return usersService.getUsers();
	}
	
	@PostMapping("/createUser")
	@CrossOrigin(origins = "*")
	public void createUser(@RequestBody Users user) {
		usersService.createUser(user);
	}
	
	@PostMapping("/userExist")
	@CrossOrigin(origins = "*")
	public List<Map<String, Object>> userExist (@RequestBody Map<String, Object> data){
		List<Map<String, Object>> nose = usersService.userExist(data);
		System.out.println(nose.toString());
		return nose;
	}
	
	@PostMapping("/verifyUser")
	@CrossOrigin(origins = "*")
	public List<Map<String, Object>> verifyUser(@RequestBody Map<String, Object> data) {
		return usersService.verifyUser(data);
	}
	
	@PutMapping("/updateUser")
	@CrossOrigin(origins = "*")
	public void updateUser(@RequestBody Users user) throws Exception {
		usersService.updateUser(user);
	}
}
