package com.jumia.exercise.internationalphonenumbers.dataAccess.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "code_regex")
    private String codeRegex;

    @Column(name = "state_regex")
    private String stateRegex;

    @Column(name = "remaining_regex")
    private String remainingRegex;

    @Column(name = "regex")
    private String regex;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the codeRegex
     */
    public String getCodeRegex() {
        return codeRegex;
    }

    /**
     * @param codeRegex the codeRegex to set
     */
    public void setCodeRegex(String codeRegex) {
        this.codeRegex = codeRegex;
    }

    /**
     * @return the stateRegex
     */
    public String getStateRegex() {
        return stateRegex;
    }

    /**
     * @param stateRegex the stateRegex to set
     */
    public void setStateRegex(String stateRegex) {
        this.stateRegex = stateRegex;
    }

    /**
     * @return the remainingRegex
     */
    public String getRemainingRegex() {
        return remainingRegex;
    }

    /**
     * @param remainingRegex the remainingRegex to set
     */
    public void setRemainingRegex(String remainingRegex) {
        this.remainingRegex = remainingRegex;
    }

    /**
     * @return the regex
     */
    public String getRegex() {
        return regex;
    }

    /**
     * @param regex the regex to set
     */
    public void setRegex(String regex) {
        this.regex = regex;
    }

    @Override
    public boolean equals(Object obj) {

        return this.getId().equals(((Country) obj).getId());
    }

}
