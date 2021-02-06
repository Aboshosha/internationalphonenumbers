package com.jumia.exercise.internationalphonenumbers.services;

import com.jumia.exercise.internationalphonenumbers.services.messages.CountryMessage;

import org.springframework.stereotype.Service;

@Service
public interface CountryService {
    CountryMessage findAllCoutries(CountryMessage message);

    CountryMessage findCountryByName(CountryMessage message, String name);

    CountryMessage findCountryByCode(CountryMessage message, String code);
}
