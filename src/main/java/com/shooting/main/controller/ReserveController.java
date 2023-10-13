package com.shooting.main.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shooting.main.model.Reserve;
import com.shooting.main.repository.ReserveRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class ReserveController {

	@Autowired
	ReserveRepository reserveRepository;

	@PostMapping("/reserve")
	public ResponseEntity<Object> Reserve(@RequestBody Reserve body) {
		try {

//			Reserve reserve = new Reserve();
//			reserve.setR_date_reserve(body.getR_date_reserve());
//			reserve.setR_time_reserve(body.getR_time_reserve());
//
//			Reserve newReserve = reserveRepository.save(reserve);
			
			Reserve newReserve = reserveRepository.save(body);
			return new ResponseEntity<>(newReserve, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
