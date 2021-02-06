package com.jumia.exercise.internationalphonenumbers.controllers;

import com.jumia.exercise.internationalphonenumbers.services.CountryService;
import com.jumia.exercise.internationalphonenumbers.services.messages.CountryMessage;
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
public class CountryController {

    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @RequestMapping(value = "/findAllCountries", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllCountries() {
        CountryMessage message = new CountryMessage();
        message = countryService.findAllCoutries(message);
        if (message.getOperationStatus().equals(OperationStatus.SUCCESSFUL)) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/findCountryByCode", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllCountryByCode(@RequestParam("countryCode") String countryCode) {
        CountryMessage message = new CountryMessage();
        message = countryService.findCountryByCode(message, countryCode);
        if (message.getOperationStatus().equals(OperationStatus.SUCCESSFUL)) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/findCountryByName", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllCountryByName(@RequestParam("countryName") String countryNmae) {
        CountryMessage message = new CountryMessage();
        message = countryService.findCountryByName(message, countryNmae);
        if (message.getOperationStatus().equals(OperationStatus.SUCCESSFUL)) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }

}
