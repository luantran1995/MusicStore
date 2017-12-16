package com.luantran.musicstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luantran.musicstore.model.Users;

public interface UserRepository extends JpaRepository<Users, Long>  {
	Users findByEmail(String email);
}
