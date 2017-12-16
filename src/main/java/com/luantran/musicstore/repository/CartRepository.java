package com.luantran.musicstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luantran.musicstore.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
