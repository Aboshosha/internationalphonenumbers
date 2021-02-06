package com.jumia.exercise.internationalphonenumbers.dataAccess.repositories;

import java.util.List;

import com.jumia.exercise.internationalphonenumbers.dataAccess.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    List<Customer> findByPhoneLike(String likePattern);

    List<Customer> findByPhoneIs(String phone);

}
