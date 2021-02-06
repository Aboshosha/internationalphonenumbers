package com.jumia.exercise.internationalphonenumbers.services;

import com.jumia.exercise.internationalphonenumbers.services.messages.CustomerMessage;

import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    CustomerMessage findAllCustormers(CustomerMessage message);

    CustomerMessage findCustomersWithPhoneNumberLike(CustomerMessage message, String likePattern);

    CustomerMessage findCustomersWithPhoneNumber(CustomerMessage message, String phoneNumber);

    CustomerMessage findPhoneNumbersByCountryCode(CustomerMessage message, String countryCode);

    CustomerMessage findPhoneNumbersByCountryCodeAndState(CustomerMessage message, String countryCode, String state);
}
