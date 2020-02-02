package com.SamHCoco.microservices.user.service.unittests.controller;

import com.SamHCoco.microservices.user.service.UserBuilder;
import com.SamHCoco.microservices.user.service.controller.UserController;
import com.SamHCoco.microservices.user.service.model.User;
import com.SamHCoco.microservices.user.service.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private User testUser;

    @Autowired
    private ObjectMapper objectMapper;

    private final static String USERS_URL = "/api/users"; // top level end point of User-Service API

    @Before
    public void setup(){
        testUser = new UserBuilder()
                .id(1L)
                .userName("JohnSmith")
                .firstName("John")
                .lastName("Smith")
                .email("john-smith@email.co.uk")
                .phone("555-555")
                .street("Test Road")
                .city("London")
                .postcode("LO2 5PH")
                .location("South-UK")
                .build();
    }

    /**
     * Test case when the getUser() controller method SUCCEEDS (the user was found).
     * @throws Exception  The likely exceptions are 'JsonProcessingException' thrown by 'writeValueAsString()',
     * 'UnsupportedEncodingException' thrown by 'getContentAsString()' and MockMvc.perform().
     */
    @Test
    public void getUserTestSuccess() throws Exception {
        when(userService.getUserDetails(testUser.getUserName()))
               .thenReturn(Optional.of(testUser));

        String expectedJSON = objectMapper.writeValueAsString(testUser);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/users/" +  testUser.getUserName())
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        assertEquals(200, response.getStatus()); // HTTP status OK test
        assertEquals(expectedJSON, response.getContentAsString()); // Controller JSON response test
    }

    /**
     * Test case when the getUser() controller method FAILS (the user could not be found).
     * @throws Exception  Covers potential exceptions thrown by MockMvc.perform().
     */
    @Test
    public void getUserTestFailure() throws Exception {
        Mockito.when(userService.getUserDetails("Non-Existent-User"))
               .thenReturn(Optional.empty());

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/users/Non-Existent-User")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        assertEquals(404, response.getStatus()); // HTTP status NOT FOUND test
    }

}
