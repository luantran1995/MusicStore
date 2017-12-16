package com.luantran.musicstore.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table(name ="cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;

	private double grandTotal;
	@NotNull
	private String name;
	@NotNull
	private String address;
	@NotNull
	private String phone;
	@OneToMany
	private List<CartItem> cartItems;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}


	public Cart(int cartId, double grandTotal, String name, String address, String phone,
			List<CartItem> cartItems) {
		super();
		this.cartId = cartId;
		this.grandTotal = grandTotal;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.cartItems = cartItems;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}


	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
}
