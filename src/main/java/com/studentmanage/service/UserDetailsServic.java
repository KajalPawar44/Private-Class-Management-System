package com.studentmanage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanage.model.User;
import com.studentmanage.repository.UserRepository;

@Service
	public class UserDetailsServic {

		@Autowired
		private UserRepository userRepository;
		
		public List<User> getAllUser()
		{
			return userRepository.findAll();
		}
		public User getUserById(Long id)
		{
			return userRepository.findById(id).orElseThrow();
		}
		
		public User saveUser(User user)
		{
			return userRepository.save(user);
		}
		public void deleteUserById(Long id)
		{
			userRepository.deleteById(id);
		}
	}

