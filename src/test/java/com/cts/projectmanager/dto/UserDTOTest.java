package com.cts.projectmanager.dto;

import org.apache.catalina.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDTOTest {
UserDTO userDTO = null;
    @Before
    public void setUp() throws Exception {
        userDTO = new UserDTO();
        userDTO.setUserId(1);
        userDTO.setLastName("last");
        userDTO.setFirstName("First");
        userDTO.setEmployeeId(2);
    }

    @Test
    public void getUserId() {
        assertEquals(1,userDTO.getUserId());
    }

    @Test
    public void setUserId() {
        userDTO.setUserId(2);
        assertEquals(2,userDTO.getUserId());
    }

    @Test
    public void getFirstName() {
        assertEquals("First",userDTO.getFirstName());
    }

    @Test
    public void setFirstName() {
        userDTO.setFirstName("firstName");
        assertEquals("firstName",userDTO.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("last",userDTO.getLastName());
    }

    @Test
    public void setLastName() {
        userDTO.setLastName("LastName");
        assertEquals("LastName",userDTO.getLastName());
    }

    @Test
    public void getEmployeeId() {
        assertEquals(2,userDTO.getEmployeeId());
    }

    @Test
    public void setEmployeeId() {
        userDTO.setEmployeeId(3);
        assertEquals(3,userDTO.getEmployeeId());
    }

    @Test
    public void testToString() {
      assertEquals("UserDTO{userId=1, firstName='First', lastName='last', employeeId=2}",userDTO.toString());
    }
}