package com.cts.projectmanager.service;

import com.cts.projectmanager.domain.UserDomainImpl;
import com.cts.projectmanager.dto.UserDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
public class UserServiceImplTest {
    @MockBean
    UserDomainImpl userDomain;

    @MockBean
    UserServiceImpl userService;

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
        userService = new UserServiceImpl(userDomain);
    }

    @Test
    public void addUser() {
        Mockito.when(userDomain.addUser(userDTO)).thenReturn(userDTOList);
        assertNotNull(userService.addUser(userDTO));

    }

    @Test
    public void editUser() {
        Mockito.when(userDomain.editUser(userDTO)).thenReturn(userDTOList);
        assertNotNull(userService.editUser(userDTO));
    }

    @Test
    public void fetchUser() {
        Mockito.when(userDomain.fetchUsers()).thenReturn(userDTOList);
        assertNotNull(userService.fetchUser());
    }

    @Test
    public void deleteUser() {
        Mockito.when(userDomain.deleteUser(userDTO)).thenReturn(userDTOList);
        assertNotNull(userService.deleteUser(userDTO));
    }
}