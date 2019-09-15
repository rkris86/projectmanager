package com.cts.projectmanager.service;

import com.cts.projectmanager.domain.IUserDomain;
import com.cts.projectmanager.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private IUserDomain userDomain;

    @Autowired
    public UserServiceImpl(IUserDomain userDomain) {
        this.userDomain = userDomain;
    }

    /**
     * Service method to add User
     *
     * @param user
     * @return
     */
    @Override
    public List<UserDTO> addUser(UserDTO user) {
        LOGGER.debug("addUser() method start " + user.toString());
        List<UserDTO> response = userDomain.addUser(user);
        LOGGER.debug("addUser() method end " + response.toString());
        return response;
    }

    /**
     * Service Method to Edit User
     *
     * @param user
     * @return
     */
    @Override
    public List<UserDTO> editUser(UserDTO user) {
        LOGGER.debug("editUser() method start" + user.toString());
        List<UserDTO> response = userDomain.editUser(user);
        LOGGER.debug("editUser() method end" + response.toString());
        return response;
    }

    /**
     * Service Method to fetch User
     *
     * @return
     */
    @Override
    public List<UserDTO> fetchUser() {
        LOGGER.debug("fetchUser() method start");
        List<UserDTO> response = userDomain.fetchUsers();
        LOGGER.debug("fetchUser() method end" + response.toString());
        return response;
    }

    /**
     * Service Method to Delete User
     *
     * @param user
     * @return
     */
    @Override
    public List<UserDTO> deleteUser(UserDTO user) {
        LOGGER.debug("deleteUser() method start" + user.toString());
        List<UserDTO> response = userDomain.deleteUser(user);
        LOGGER.debug("deleteUser() method end" + response.toString());
        return response;
    }
}
