package com.cts.projectmanager.domain;

import com.cts.projectmanager.dto.UserDTO;

import java.util.List;

public interface IUserDomain {
    /**
     * Domain method to add New User
     * @param user
     * @return
     */
    List<UserDTO> addUser(UserDTO user);

    /**
     * Domain method to Edit User
     * @param user
     * @return
     */
    List<UserDTO> editUser(UserDTO user);

    /**
     * Domain Method to Fetch User
     * @return
     */
    List<UserDTO> fetchUsers();
    /**
     * Domain method to Delete User
     * @param user
     * @return
     */
    List<UserDTO> deleteUser(UserDTO user);

}
