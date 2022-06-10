/**
 * 
 */
package com.address.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.address.app.service.AddressService;

/**
 * @author Vaibhav Jadhav
 *
 */
@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping("/get/address/{userId}")
	public ResponseEntity<String> getAddressByUserId(@PathVariable int userId) {
		return new ResponseEntity<>(addressService.getAddressByUserId(userId), HttpStatus.OK);
	}

	@GetMapping("/get/user/{id}")
	public ResponseEntity<String> getUserNameById(@PathVariable int id) {
		return new ResponseEntity<String>(addressService.getUserNameById(id), HttpStatus.OK);
	}
}
