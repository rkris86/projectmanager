package com.cts.projectmanager.eo;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class UsersEOTest {
    UsersEO user = null;
    UsersEO newUser = null;

    @Before
    public void setUp() throws Exception {
        user = new UsersEO();
        user.setUserId(0);
        user.setEmployeeId(0);
        user.setFirstName("first");
        user.setLastName("last");
       // user.setProjectId(2L);
       // user.setTaskId(2L);

        newUser = new UsersEO();
        newUser.setUserId(0);
        newUser.setEmployeeId(0);
        newUser.setFirstName("first");
        newUser.setLastName("last");
       // newUser.setProjectId(2L);
     //   newUser.setTaskId(2L);
    }

    @Test
    public void getUserId() {
        assertEquals(0,user.getUserId());
    }

    @Test
    public void setUserId() {
        user.setUserId(1);
        assertEquals(1,user.getUserId());
    }

    @Test
    public void getFirstName() {
        assertEquals("first",user.getFirstName());
    }

    @Test
    public void setFirstName() {
        user.setFirstName("firstName");
        assertEquals("firstName",user.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("last",user.getLastName());
    }

    @Test
    public void setLastName() {
        user.setLastName("lastName");
        assertEquals("lastName",user.getLastName());
    }

    @Test
    public void getEmployeeId() {
        assertEquals(0,user.getEmployeeId());
    }

    @Test
    public void setEmployeeId() {
        user.setEmployeeId(3);
        assertEquals(3,user.getEmployeeId());
    }

    @Test
    public void getProjectId() {
      //  assertEquals(new Long(2L),user.getProjectId());

    }

    @Test
    public void setProjectId() {
      //  user.setProjectId(3L);
     //   assertEquals( new Long(3L) , user.getProjectId());
    }

    @Test
    public void getTaskId() {
        //assertEquals(new Long(2L),user.getTaskId());
    }

    @Test
    public void setTaskId() {
   //     user.setTaskId(3L);
    //    assertEquals(new Long(3L),user.getTaskId());
    }

    @Test
    public void testEquals() {
        assertTrue(user.equals(newUser));
    }

    @Test
    public void testHashCode() {
        assertNotNull(user.hashCode());
    }
}