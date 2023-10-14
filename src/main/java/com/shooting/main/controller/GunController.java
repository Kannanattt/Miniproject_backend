package com.shooting.main.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shooting.main.model.Gun;
import com.shooting.main.repository.GunRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class GunController {
	@Autowired
	GunRepository gunRepository;

	@PostMapping("/gun")
	public ResponseEntity<Object> addGun(@RequestBody Gun gun) {
		try {
			// Save the gun to the database
			Gun newGun = gunRepository.save(gun);
			return new ResponseEntity<>(newGun, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/guns")
	public ResponseEntity<Object> getAllGuns() {
		try {
			List<Gun> guns = gunRepository.findAll();
			return new ResponseEntity<>(guns, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/gun/{g_id}")
	public ResponseEntity<Object> getGunById(@PathVariable Long g_id) {
		try {
			Optional<Gun> gun = gunRepository.findById(g_id);
			if (gun.isPresent()) {
				return new ResponseEntity<>(gun, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Gun not found.", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/gun/{g_id}")
	public ResponseEntity<Object> deleteGunById(@PathVariable Long g_id) {
		try {
			Optional<Gun> gun = gunRepository.findById(g_id);
			if (gun.isPresent()) {
				gunRepository.delete(gun.get());
				return new ResponseEntity<>("Delete Gun Success", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Gun not found.", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/gun/{g_id}")
	public ResponseEntity<Object> editGunById(@PathVariable Long g_id, @RequestBody Gun updatedGun) {
		try {
			Optional<Gun> gun = gunRepository.findById(g_id);
			if (gun.isPresent()) {
				Gun gunEdit = gun.get();
				gunEdit.setG_name(updatedGun.getG_name());
				gunRepository.save(gunEdit);
				return new ResponseEntity<>(gunEdit, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Gun not found.", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
