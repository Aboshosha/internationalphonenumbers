package com.jumia.exercise.internationalphonenumbers.endpoints;

import com.jumia.exercise.internationalphonenumbers.controllers.CustomerController;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CustomerController.class)
@AutoConfigureMockMvc(addFilters = false)
@WebAppConfiguration
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllCutomers() throws Exception {
        RequestBuilder request = get("/findAllPhoneNumbers");
        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals(HttpStatus.OK, result.getResponse().getStatus());
        assertEquals(true, result.getResponse().getContentAsString().contains("customers"));
    }
}
