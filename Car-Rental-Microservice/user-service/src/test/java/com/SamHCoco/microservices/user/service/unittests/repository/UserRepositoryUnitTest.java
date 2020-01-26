package com.SamHCoco.microservices.user.service.unittests.repository;

import com.SamHCoco.microservices.user.service.UserBuilder;
import com.SamHCoco.microservices.user.service.model.User;
import com.SamHCoco.microservices.user.service.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryUnitTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
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
    public void saveTest(){
        userRepository.save(testUser);
        assertThat(userRepository.findById(testUser.getId()).get()).isEqualToComparingFieldByField(testUser);
    }

}
