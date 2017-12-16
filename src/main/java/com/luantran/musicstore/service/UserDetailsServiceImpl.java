package com.luantran.musicstore.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luantran.musicstore.model.Role;
import com.luantran.musicstore.model.Users;
import com.luantran.musicstore.repository.UserRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl  implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		  Users user = userRepository.findByEmail(username);
	        if (user == null) {
	            throw new UsernameNotFoundException("User not found");
	        }
	        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	        Set<Role> roles = user.getRoles();
	        for (Role role : roles) {
	            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
	        }
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
	}

}
