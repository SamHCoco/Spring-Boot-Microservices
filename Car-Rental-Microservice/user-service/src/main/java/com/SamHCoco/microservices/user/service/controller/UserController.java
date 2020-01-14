package com.SamHCoco.microservices.user.service.controller;

import com.SamHCoco.microservices.user.service.model.User;
import com.SamHCoco.microservices.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Finds and returns the details of a single user.
     * @param userName The user name of the user to be found in the user database.
     * @return HTTP status 200 (OK) and User object containing all personal
     * details of the user (address, email phone number etc), or HTTP status
     * 404 if the user was not found in the database.
     */
    @GetMapping("api/users/{userName}")
    public ResponseEntity<User> getUser(@PathVariable String userName){
        Optional<User> user = userService.getUserDetails(userName);

        if(user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Adds a single user to the user database.
     * @param user The user to be added to the user database.
     * @return HTTP status 200 (OK) if the user was successfully added,
     * or HTTP status 400 (BAD REQUEST) if the user could not be added.
     */
    @PostMapping("api/users")
    public ResponseEntity addUser(@Valid @RequestBody User user){
        boolean added = userService.addUser(user);

        if(added){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
