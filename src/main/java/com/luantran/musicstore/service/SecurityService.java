package com.luantran.musicstore.service;

public interface SecurityService {
	 String findLoggedInEmail();
	 void autologin(String username, String password);
}
