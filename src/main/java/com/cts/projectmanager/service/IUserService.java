package com.cts.projectmanager.service;

import com.cts.projectmanager.dto.UserDTO;

import java.util.List;

public interface IUserService {
    /**
     * Service method to add User
     * @param user
     * @return
     */
    List<UserDTO> addUser(UserDTO user);

    /**
     * Service Method to Edit User
     * @param user
     * @return
     */
    List<UserDTO> editUser(UserDTO user);

    /**
     * Service Method to fetch User
     * @return
     */
    List<UserDTO> fetchUser();
    /**
     * Service Method to Delete User
     * @param user
     * @return
     */
    List<UserDTO> deleteUser(UserDTO user);
}
