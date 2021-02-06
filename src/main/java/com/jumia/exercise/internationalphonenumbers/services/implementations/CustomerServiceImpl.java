package com.jumia.exercise.internationalphonenumbers.services.implementations;

import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.jumia.exercise.internationalphonenumbers.dataAccess.entities.Country;
import com.jumia.exercise.internationalphonenumbers.dataAccess.entities.Customer;
import com.jumia.exercise.internationalphonenumbers.dataAccess.repositories.CountryRepository;
import com.jumia.exercise.internationalphonenumbers.dataAccess.repositories.CustomerRepository;
import com.jumia.exercise.internationalphonenumbers.services.CustomerService;
import com.jumia.exercise.internationalphonenumbers.services.messages.CustomerMessage;
import com.jumia.exercise.internationalphonenumbers.services.messages.OperationStatus;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public CustomerMessage findAllCustormers(CustomerMessage message) {
        message.setOperationStatus(OperationStatus.SUCCESSFUL);
        message.setErrorMessage("N/A");
        message.setCustomers(customerRepository.findAll());
        return message;
    }

    @Override
    public CustomerMessage findCustomersWithPhoneNumberLike(CustomerMessage message, String likePattern) {

        message.setCustomers(customerRepository.findByPhoneLike(likePattern));
        if (message.getCustomers() != null && IterableUtils.size(message.getCustomers()) != 0) {
            message.setOperationStatus(OperationStatus.SUCCESSFUL);
            message.setErrorMessage("N/A");
        } else {
            message.setOperationStatus(OperationStatus.UNSUCCESSFUL);
            message.setErrorMessage("There are no phone numbers with this pattern : " + likePattern + "!");
        }
        return message;
    }

    @Override
    public CustomerMessage findCustomersWithPhoneNumber(CustomerMessage message, String phoneNumber) {

        message.setCustomers(customerRepository.findByPhoneIs(phoneNumber));
        if (message.getCustomers() != null && IterableUtils.size(message.getCustomers()) == 1) {
            message.setOperationStatus(OperationStatus.SUCCESSFUL);
            message.setErrorMessage("N/A");
        } else {
            message.setOperationStatus(OperationStatus.UNSUCCESSFUL);
            message.setErrorMessage("Phone number : " + phoneNumber + " is not in the records!");
        }
        return message;
    }

    @Override
    public CustomerMessage findPhoneNumbersByCountryCode(CustomerMessage message, String countryCode) {

        message.setOperationStatus(OperationStatus.UNSUCCESSFUL);
        message.setErrorMessage("Phone numbers with country code : " + countryCode + " are not in the records!");
        Iterator<Country> coutriesItrator = countryRepository.findByCodeIs(countryCode).iterator();
        if (coutriesItrator.hasNext()) {
            Country country = coutriesItrator.next();
            String regex = country.getRegex();
            Iterable<Customer> customers = StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                    .filter((customer) -> customer.getPhone().matches(regex)).collect(Collectors.toList());
            if (customers != null && IterableUtils.size(customers) != 0) {
                message.setOperationStatus(OperationStatus.SUCCESSFUL);
                message.setErrorMessage("N/A");
                message.setCustomers(customers);
            }
        }
        return message;
    }

    @Override
    public CustomerMessage findPhoneNumbersByCountryCodeAndState(CustomerMessage message, String countryCode,
            String state) {
        message.setOperationStatus(OperationStatus.UNSUCCESSFUL);
        Iterator<Country> coutriesItrator = countryRepository.findByCodeIs(countryCode).iterator();
        if (!coutriesItrator.hasNext()) {
            message.setErrorMessage("Phone numbers with country code : " + countryCode + " are not in the records!");
        } else {
            Country country = coutriesItrator.next();
            String stateRegex = country.getStateRegex();
            if (!state.matches(stateRegex)) {
                message.setErrorMessage("This is not a valid state for " + country.getName() + " !");
            } else {
                Iterable<Customer> customers = StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                        .filter((customer) -> customer.getPhone()
                                .matches(country.getCodeRegex() + "\\ ?[" + state + "]" + country.getRemainingRegex()))
                        .collect(Collectors.toList());

                if (customers == null || IterableUtils.size(customers) == 0) {
                    message.setErrorMessage("Phone numbers with country code : " + countryCode + " and state : " + state
                            + " are not in the records!");
                } else {
                    message.setOperationStatus(OperationStatus.SUCCESSFUL);
                    message.setErrorMessage("N/A");
                    message.setCustomers(customers);
                }
            }
        }
        return message;
    }

}
