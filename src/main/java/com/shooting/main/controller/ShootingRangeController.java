package com.shooting.main.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shooting.main.model.ShootingRange;
import com.shooting.main.repository.ShootingRangeRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class ShootingRangeController {
    @Autowired
    ShootingRangeRepository shootingRangeRepository;

    @PostMapping("/shootingrange")
    public ResponseEntity<Object> addShootingRange(@RequestBody ShootingRange shootingRange) {
        try {
            // Save the shooting range to the database
            ShootingRange newShootingRange = shootingRangeRepository.save(shootingRange);
            return new ResponseEntity<>(newShootingRange, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/shootingranges")
    public ResponseEntity<Object> getAllShootingRanges() {
        try {
            List<ShootingRange> shootingRanges = shootingRangeRepository.findAll();
            return new ResponseEntity<>(shootingRanges, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/shootingrange/{s_id}")
    public ResponseEntity<Object> getShootingRangeById(@PathVariable Long s_id) {
        try {
            Optional<ShootingRange> shootingRange = shootingRangeRepository.findById(s_id);
            if (shootingRange.isPresent()) {
                return new ResponseEntity<>(shootingRange, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Shooting Range not found.", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/shootingrange/{s_id}")
    public ResponseEntity<Object> deleteShootingRangeById(@PathVariable Long s_id) {
        try {
            Optional<ShootingRange> shootingRange = shootingRangeRepository.findById(s_id);
            if (shootingRange.isPresent()) {
                shootingRangeRepository.delete(shootingRange.get());
                return new ResponseEntity<>("Delete Shooting Range Success", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Shooting Range not found.", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/shootingrange/{s_id}")
    public ResponseEntity<Object> editShootingRangeById(@PathVariable Long s_id, @RequestBody ShootingRange updatedShootingRange) {
        try {
            Optional<ShootingRange> shootingRange = shootingRangeRepository.findById(s_id);
            if (shootingRange.isPresent()) {
                ShootingRange shootingRangeEdit = shootingRange.get();
                shootingRangeEdit.setS_name(updatedShootingRange.getS_name());
                // You can also update the associated ShootingStatus here if needed.
                shootingRangeRepository.save(shootingRangeEdit);
                return new ResponseEntity<>(shootingRangeEdit, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Shooting Range not found.", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
