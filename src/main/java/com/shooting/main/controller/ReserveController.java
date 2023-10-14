package com.shooting.main.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shooting.main.model.Reserve;
import com.shooting.main.repository.ReserveRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class ReserveController {
    @Autowired
    ReserveRepository reserveRepository;

    @PostMapping("/reserve")
    public ResponseEntity<Object> addReserve(@RequestBody Reserve reserve) {
        try {
            // Save the reserve to the database
            Reserve newReserve = reserveRepository.save(reserve);
            return new ResponseEntity<>(newReserve, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/reserves")
    public ResponseEntity<Object> getAllReserves() {
        try {
            List<Reserve> reserves = reserveRepository.findAll();
            return new ResponseEntity<>(reserves, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/reserve/{r_id}")
    public ResponseEntity<Object> getReserveById(@PathVariable Long r_id) {
        try {
            Optional<Reserve> reserve = reserveRepository.findById(r_id);
            if (reserve.isPresent()) {
                return new ResponseEntity<>(reserve, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Reserve not found.", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/reserve/{r_id}")
    public ResponseEntity<Object> deleteReserveById(@PathVariable Long r_id) {
        try {
            Optional<Reserve> reserve = reserveRepository.findById(r_id);
            if (reserve.isPresent()) {
                reserveRepository.delete(reserve.get());
                return new ResponseEntity<>("Delete Reserve Success", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Reserve not found.", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/reserve/{r_id}")
    public ResponseEntity<Object> editReserveById(@PathVariable Long r_id, @RequestBody Reserve updatedReserve) {
        try {
            Optional<Reserve> reserve = reserveRepository.findById(r_id);
            if (reserve.isPresent()) {
                Reserve reserveEdit = reserve.get();
                reserveEdit.setR_date_reserve(updatedReserve.getR_date_reserve());
                reserveEdit.setR_time_reserve(updatedReserve.getR_time_reserve());
                reserveEdit.setCustomer(updatedReserve.getCustomer());
                reserveEdit.setShootingRange(updatedReserve.getShootingRange());
                reserveEdit.setGuns(updatedReserve.getGuns());
                // You can also update the associated Customer and Guns here if needed.
                reserveRepository.save(reserveEdit);
                return new ResponseEntity<>(reserveEdit, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Reserve not found.", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
