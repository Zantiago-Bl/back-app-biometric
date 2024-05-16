package com.example.demo.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Users;
import com.example.demo.repositories.UsersRepository;


@Service
public class UsersService {
	
	@Autowired
	public UsersRepository userRepository;
	
	public List<Users> getUsers (){
		return userRepository.findAll();
	}
	
	public void createUser(Users user) {
		userRepository.save(user);
	}
	
	public List<Map<String, Object>> userExist (Map<String, Object> data){
		String user = data.get("user").toString();
		return userRepository.userExist(user);
	}
	
	public List<Map<String, Object>> verifyUser (Map<String, Object> data) {
		String user = data.get("user").toString();
		String password = data.get("password").toString();
		return userRepository.verifyUser(user, password);
	}
	
	public void updateUser(Users user) throws Exception {
		Optional<Users> data = userRepository.findById(user.getId());
		if(data.isEmpty()) {
			throw new Exception("Error");
		}
		data.get().setDeviceId(user.getDeviceId());
		userRepository.save(data.get());
	}
}
