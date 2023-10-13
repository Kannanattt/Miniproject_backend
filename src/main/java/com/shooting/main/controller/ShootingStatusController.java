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

import com.shooting.main.model.ShootingStatus;
import com.shooting.main.repository.ShootingStatusRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class ShootingStatusController {
	@Autowired
	ShootingStatusRepository shootingStatusRepository;

	@PostMapping("/status")
	public ResponseEntity<Object> addStatus(@RequestBody ShootingStatus status) {
		try {
			// Save the status to the database
			ShootingStatus newStatus = shootingStatusRepository.save(status);
			return new ResponseEntity<>(newStatus, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/status")
	public ResponseEntity<Object> getAllStatuses() {

		try {
			List<ShootingStatus> statuses = shootingStatusRepository.findAll();
			return new ResponseEntity<>(statuses, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/status/{statusId}")
	public ResponseEntity<Object> getStatusById(@PathVariable Long statusId) {
		try {

			Optional<ShootingStatus> shootingStatus = shootingStatusRepository.findById(statusId);
			if (shootingStatus.isPresent()) {

				return new ResponseEntity<>(shootingStatus, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Status not found.", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/status/{statusId}")
	public ResponseEntity<Object> deleteStatusById(@PathVariable Long statusId) {
		try {

			Optional<ShootingStatus> shootingStatus = shootingStatusRepository.findById(statusId);
			if (shootingStatus.isPresent()) {
				shootingStatusRepository.delete(shootingStatus.get());
				return new ResponseEntity<>("Delete Status Success", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Status not found.", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/status/{statusId}")
	public ResponseEntity<Object> editStatusById(@PathVariable Long statusId,
			@RequestBody ShootingStatus updatedStatus) {

		try {

			Optional<ShootingStatus> shootingStatus = shootingStatusRepository.findById(statusId);
			if (shootingStatus.isPresent()) {
				ShootingStatus statusEdit = shootingStatus.get();
				statusEdit.setStatus_name(updatedStatus.getStatus_name());
				shootingStatusRepository.save(statusEdit);
				return new ResponseEntity<>(statusEdit, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Status not found.", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
