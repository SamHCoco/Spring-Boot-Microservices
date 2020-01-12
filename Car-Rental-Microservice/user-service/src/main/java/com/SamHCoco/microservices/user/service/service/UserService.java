package com.SamHCoco.microservices.user.service.service;

import com.SamHCoco.microservices.user.service.model.User;
import com.SamHCoco.microservices.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Gets the all details of a single user (address, full name, email etc) from the database.
     * @param userName The user name of the user to be found.
     * @return A User object containing all the details of a single user.
     */
    public Optional<User> getUserDetails(String userName){
        return userRepository.findByuserName(userName);
    }

    /**
     * Adds user to the user database and checks whether
     * the add operation was successful.
     * @param user The user to be added to the user database.
     * @return True if the user was successfully added, false otherwise.
     */
    public boolean addUser(User user){
        boolean added = false;
        userRepository.save(user);
        if(userRepository.existsByuserName(user.getUserName())){
            added = true;
        }
        return added;
    }

}
