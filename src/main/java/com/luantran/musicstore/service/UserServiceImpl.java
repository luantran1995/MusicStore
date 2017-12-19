package com.luantran.musicstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luantran.musicstore.model.Users;
import com.luantran.musicstore.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void save(Users user) {
	
        userRepository.save(user);
        System.out.println("save user ");
	}

	@Override
	public Users findByUsername(String username) {
		System.out.println("find by username");
        return userRepository.findByEmail(username);

	}

}
