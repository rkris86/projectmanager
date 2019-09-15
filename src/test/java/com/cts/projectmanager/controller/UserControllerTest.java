package com.cts.projectmanager.controller;

import com.cts.projectmanager.dto.UserDTO;
import com.cts.projectmanager.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @MockBean
    UserServiceImpl userService;
    @MockBean
    UserController userController;

    List<UserDTO> userDTOList = new ArrayList<>();
    UserDTO userDTO = null;

    @Before
    public void setUp() throws Exception {
        userDTO = new UserDTO();
        userDTO.setUserId(1);
        userDTO.setLastName("last");
        userDTO.setFirstName("First");
        userDTO.setEmployeeId(2);
        userDTOList.add(userDTO);
        userController = new UserController(userService);
    }

    @Test
    public void addUser() {
        Mockito.when(userService.addUser(userDTO)).thenReturn(userDTOList);
        assertNotNull(userController.addUser(userDTO));
    }

    @Test
    public void editUser() {
        Mockito.when(userService.editUser(userDTO)).thenReturn(userDTOList);
        assertNotNull(userController.editUser(userDTO));
    }

    @Test
    public void fetchUser() {
        Mockito.when(userService.fetchUser()).thenReturn(userDTOList);
        assertNotNull(userController.fetchUser());
    }

    @Test
    public void deleteUser() {
        Mockito.when(userService.deleteUser(userDTO)).thenReturn(userDTOList);
        assertNotNull(userController.deleteUser(userDTO));
    }
}