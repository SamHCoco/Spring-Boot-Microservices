package com.SamHCoco.microservices.user.service.unittests.service;

import com.SamHCoco.microservices.user.service.model.User;
import com.SamHCoco.microservices.user.service.repository.UserRepository;
import com.SamHCoco.microservices.user.service.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/*
    The @ContextConfiguration annotation allows us to tell Spring which beans we'd like to
    create, in this case for testing. The SpringBootTest annotation initializes all beans
    in the application, which can be an issue for very large applications (testing would be slow).
    The @ContextConfiguration annotation allows us to initialize only the beans we're interested in.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {UserService.class})
public class UserServiceUnitTest {

    @Autowired
    private UserService userService;

    /* Dummy 'mock' repository, since we want to test the UserService only (Unit Test),
       and not UserService + UserRepository as this would be an Integration Test.
       NOTE: The 'MockBean' annotation is part of Mockito. It tells Spring to
       create a fake 'dummy' bean instead of a real one.
    */
    @MockBean
    private UserRepository userRepository;

    private User testUser;

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


    @Test
    public void addUserTest(){
        Mockito.when(userRepository.existsByuserName(testUser.getUserName()))
                .thenReturn(true);

        Assert.assertTrue(userService.addUser(testUser));
    }

}
