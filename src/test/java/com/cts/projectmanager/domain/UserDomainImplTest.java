package com.cts.projectmanager.domain;


import com.cts.projectmanager.dto.UserDTO;
import com.cts.projectmanager.eo.UsersEO;
import com.cts.projectmanager.repository.IUsersRepository;
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
public class UserDomainImplTest {
    @MockBean
    UserDomainImpl userDomain;
    @MockBean
    IUsersRepository iUsersRepository;
    UserDTO userDTO = null;
    UsersEO usersEO = null;
    List<UsersEO> userList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {

        userDTO = new UserDTO();
        userDTO.setUserId(1);
        userDTO.setLastName("last");
        userDTO.setFirstName("First");
        userDTO.setEmployeeId(2);
        userDomain = new UserDomainImpl(iUsersRepository);

        usersEO = new UsersEO();
        usersEO.setUserId(userDTO.getUserId());
        usersEO.setEmployeeId(userDTO.getEmployeeId());
        usersEO.setLastName(userDTO.getLastName());
        usersEO.setFirstName(userDTO.getFirstName());
        usersEO.setUserId(1);
        userList.add(usersEO);
    }

    @Test
    public void addUser() {
        Mockito.when(iUsersRepository.saveAndFlush(usersEO)).thenReturn(usersEO);
        Mockito.when(iUsersRepository.findAll()).thenReturn(userList);
        assertNotNull(userDomain.addUser(userDTO));

    }

    @Test
    public void editUser() {
        Mockito.when(iUsersRepository.saveAndFlush(usersEO)).thenReturn(usersEO);
        Mockito.when(iUsersRepository.findAll()).thenReturn(userList);
        assertNotNull(userDomain.editUser(userDTO));
    }

    @Test
    public void fetchUsers() {
        Mockito.when(iUsersRepository.findAll()).thenReturn(userList);
        assertNotNull(userDomain.fetchUsers());
    }

    @Test
    public void deleteUser() {
        Mockito.doNothing().when(iUsersRepository).delete(usersEO);
        Mockito.when(iUsersRepository.findAll()).thenReturn(userList);
        assertNotNull(userDomain.deleteUser(userDTO));
    }
}