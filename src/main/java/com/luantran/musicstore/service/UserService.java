package com.luantran.musicstore.service;

import com.luantran.musicstore.model.Users;

public interface UserService { 
	 void save(Users user);

	  Users findByUsername(String username);

}
