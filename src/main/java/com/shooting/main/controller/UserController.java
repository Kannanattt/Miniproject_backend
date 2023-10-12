package com.shooting.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shooting.main.model.User;
import com.shooting.main.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/user")
	public ResponseEntity<Object> getAllUser() {

		try {
			List<User> listUser = userRepository.findAll();
			return new ResponseEntity<>(listUser, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/user")
	public ResponseEntity<Object> addUser(@RequestBody User body) {

		try {

			User newUser = userRepository.save(body);
			return new ResponseEntity<>(newUser, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/user/{userID}")
	public ResponseEntity<Object> getUserById(@PathVariable Long userID) {

		try {

			Optional<User> userFound = userRepository.findById(userID);
			if (userFound.isPresent()) {
				return new ResponseEntity<>(userFound, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("User Not Found.", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/user/{userID}")
	public ResponseEntity<Object> updateEmployee(@PathVariable Long userID, @RequestBody User body) {

		try {

			Optional<User> user = userRepository.findById(userID);

			if (user.isPresent()) {
				User userEdit = user.get();

				userEdit.setUsername(body.getUsername());
				userEdit.setPassword(body.getPassword());
				userEdit.setRole(body.getRole());

				userRepository.save(userEdit);

				return new ResponseEntity<>(userEdit, HttpStatus.OK);

			} else {
				return new ResponseEntity<>("User Not Found.", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/user/{userID}")
	public ResponseEntity<Object> deleteUserById(@PathVariable Long userID) {

		try {
			Optional<User> user = userRepository.findById(userID);

			if (user.isPresent()) {
				userRepository.delete(user.get());
				return new ResponseEntity<>("Delete User Success.", HttpStatus.OK);

			} else {
				return new ResponseEntity<>("User Not Found.", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}