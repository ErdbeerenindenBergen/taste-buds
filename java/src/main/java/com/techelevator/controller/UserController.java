package com.techelevator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import com.techelevator.dao.UserDao;
import com.techelevator.model.User;

@RestController
@PreAuthorize("isAuthenticated()")
//"user" is added to BASE_API_URL
@RequestMapping("user")
@CrossOrigin
public class UserController {

    UserDao userDao;

    public UserController(UserDao userDao) { this.userDao = userDao;}

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<User> listAllUsers() {
        return userDao.findAll();
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping (path = "/{emailAddress}", method = RequestMethod.GET)
    public User findUserByEmail(@PathVariable String emailAddress) {
        User user = userDao.findUserByEmail(emailAddress);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
        } else {
            return user;
        }
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping (path = "/{userId}", method = RequestMethod.GET)
    public User getUserByUserId(@PathVariable int userId) {
        User user = userDao.getUserById(userId);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
        } else {
            return user;
        }
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping (path = "/{username}", method = RequestMethod.GET)
    public User findByUsername(String username) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
        } else {
            return user;
        }
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping (path = "user/userId/{username}", method = RequestMethod.GET)
    public int findIdByUsername(String username) {
        return userDao.findIdByUsername(username);
    }
}
