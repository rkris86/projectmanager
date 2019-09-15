package com.cts.projectmanager.controller;

import com.cts.projectmanager.dto.UserDTO;
import com.cts.projectmanager.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    List<UserDTO> addUser(@RequestBody UserDTO user) {
        LOGGER.debug("addUser() method start" + user.toString());
        List<UserDTO> response = userService.addUser(user);
        LOGGER.debug("addUser() method end" + response.toString());
        return response;
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    List<UserDTO> editUser(@RequestBody UserDTO user) {
        LOGGER.debug("editUser() method start" + user.toString());
        List<UserDTO> response = userService.editUser(user);
        LOGGER.debug("editUser() method end" + response.toString());
        return response;
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    List<UserDTO> fetchUser() {
        LOGGER.debug("fetchUser() method start");
        List<UserDTO> response = userService.fetchUser();
        LOGGER.debug("fetchUser() method end" + response.toString());
        return response;
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    List<UserDTO> deleteUser(@RequestBody UserDTO user) {
        LOGGER.debug("deleteUser() method start");
        List<UserDTO> response = userService.deleteUser(user);
        LOGGER.debug("deleteUser() method end" + response.toString());
        return response;
    }
}
