package com.luantran.musicstore.config;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.luantran.musicstore.model.Role;
import com.luantran.musicstore.model.Users;
import com.luantran.musicstore.repository.RoleRepository;
import com.luantran.musicstore.repository.UserRepository;

@Component

public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
	
	
	  @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private RoleRepository roleRepository;

//	    @Autowired 
//	    private PasswordEncoder passwordEncoder;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// Roles
        if (roleRepository.findByName("ROLE_ADMIN") == null) {
            roleRepository.save(new Role("ROLE_ADMIN"));
        }

        if (roleRepository.findByName("ROLE_MEMBER") == null) {
            roleRepository.save(new Role("ROLE_MEMBER"));
        }

        // Admin account
        if (userRepository.findByEmail("admin@gmail.com") == null) {
            Users admin = new Users();
            admin.setEmail("admin@gmail.com");
//            admin.setPassword(passwordEncoder.encode("123456"));
            admin.setPassword("123456");

            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_ADMIN"));
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            admin.setRoles(roles);
            userRepository.save(admin);
        }

        // Member account
        if (userRepository.findByEmail("member@gmail.com") == null) {
            Users user = new Users();
            user.setEmail("member@gmail.com");
//            user.setPassword(passwordEncoder.encode("123456"));
            user.setPassword("123456");
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            user.setRoles(roles);
            userRepository.save(user);
        }
    }
		
	}
	


