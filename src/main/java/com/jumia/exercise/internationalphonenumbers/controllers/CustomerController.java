package com.jumia.exercise.internationalphonenumbers.controllers;

import com.jumia.exercise.internationalphonenumbers.services.CustomerService;
import com.jumia.exercise.internationalphonenumbers.services.messages.CustomerMessage;
import com.jumia.exercise.internationalphonenumbers.services.messages.OperationStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/findAllPhoneNumbers", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllCustomers() {
        CustomerMessage message = new CustomerMessage();
        message = customerService.findAllCustormers(message);
        if (message.getOperationStatus().equals(OperationStatus.SUCCESSFUL)) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/findPhoneNumbersByCountryCode", method = RequestMethod.GET)
    public ResponseEntity<Object> getCustomersPhoneNumberByCountry(@RequestParam("countryCode") String countryCode) {
        CustomerMessage message = new CustomerMessage();
        message = customerService.findPhoneNumbersByCountryCode(message, countryCode);
        if (message.getOperationStatus().equals(OperationStatus.SUCCESSFUL)) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/findPhoneNumbersByCountryCodeAndState", method = RequestMethod.GET)
    public ResponseEntity<Object> getCustomersPhoneNumberByCountryAndState(
            @RequestParam("countryCode") String countryCode, @RequestParam("state") String state) {
        CustomerMessage message = new CustomerMessage();
        message = customerService.findPhoneNumbersByCountryCodeAndState(message, countryCode, state);
        if (message.getOperationStatus().equals(OperationStatus.SUCCESSFUL)) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/findPhoneNumber", method = RequestMethod.GET)
    public ResponseEntity<Object> getCustomerByPhoneNumber(@RequestParam("phone") String phoneNumber) {
        CustomerMessage message = new CustomerMessage();
        message = customerService.findCustomersWithPhoneNumber(message, phoneNumber);
        if (message.getOperationStatus().equals(OperationStatus.SUCCESSFUL)) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }

}
