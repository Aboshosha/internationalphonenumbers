package com.jumia.exercise.internationalphonenumbers.services.messages;

import com.jumia.exercise.internationalphonenumbers.dataAccess.entities.Country;

public class CountryMessage extends Message {

    private Iterable<Country> countries;

    public void setCoutries(Iterable<Country> countries) {
        this.countries = countries;
    }

    public Iterable<Country> getCountries() {
        return countries;
    }

}
