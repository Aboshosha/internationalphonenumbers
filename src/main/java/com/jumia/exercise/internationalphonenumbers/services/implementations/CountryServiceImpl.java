package com.jumia.exercise.internationalphonenumbers.services.implementations;

import com.jumia.exercise.internationalphonenumbers.dataAccess.repositories.CountryRepository;
import com.jumia.exercise.internationalphonenumbers.services.CountryService;
import com.jumia.exercise.internationalphonenumbers.services.messages.CountryMessage;
import com.jumia.exercise.internationalphonenumbers.services.messages.OperationStatus;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public CountryMessage findAllCoutries(CountryMessage message) {
        message.setOperationStatus(OperationStatus.SUCCESSFUL);
        message.setErrorMessage("N/A");
        message.setCoutries(countryRepository.findAll());
        return message;
    }

    @Override
    public CountryMessage findCountryByName(CountryMessage message, String name) {
        message.setCoutries(countryRepository.findByNameIs(name));
        if (message.getCountries() != null && IterableUtils.size(message.getCountries()) != 0) {
            message.setOperationStatus(OperationStatus.SUCCESSFUL);
            message.setErrorMessage("N/A");
        } else {
            message.setOperationStatus(OperationStatus.UNSUCCESSFUL);
            message.setErrorMessage("There is no country with this name : " + name + "!");
        }
        return message;
    }

    @Override
    public CountryMessage findCountryByCode(CountryMessage message, String code) {
        message.setCoutries(countryRepository.findByCodeIs(code));
        if (message.getCountries() != null && IterableUtils.size(message.getCountries()) != 0) {
            message.setOperationStatus(OperationStatus.SUCCESSFUL);
            message.setErrorMessage("N/A");
        } else {
            message.setOperationStatus(OperationStatus.UNSUCCESSFUL);
            message.setErrorMessage("There is no country with this code : " + code + "!");
        }
        return message;
    }

}
