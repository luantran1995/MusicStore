package com.luantran.musicstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luantran.musicstore.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findByName(String name);

}
