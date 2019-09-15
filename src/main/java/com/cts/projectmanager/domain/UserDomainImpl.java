package com.cts.projectmanager.domain;

import com.cts.projectmanager.dto.UserDTO;
import com.cts.projectmanager.eo.UsersEO;
import com.cts.projectmanager.repository.IUsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDomainImpl implements IUserDomain {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDomainImpl.class);
    private IUsersRepository usersRepository;

    @Autowired
    public UserDomainImpl(IUsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * Domain method to add New User
     *
     * @param user
     * @return
     */
    @Override
    public List<UserDTO> addUser(UserDTO user) {
        LOGGER.debug("addUser() method start" + user.toString());
        UsersEO usersEO = new UsersEO();
        usersEO.setFirstName(user.getFirstName());
        usersEO.setLastName(user.getLastName());
        usersEO.setEmployeeId(user.getEmployeeId());
        if(user.getUserId()>0){
            usersEO.setUserId(user.getUserId());
        }
        usersRepository.saveAndFlush(usersEO);
        List<UserDTO> response = getUsers();
        LOGGER.debug("addUser() method end" + response.toString());
        return response;
    }

    private List<UserDTO> getUsers() {
        List<UsersEO> usersEOS = usersRepository.findAll();
        List<UserDTO> finalUsers = new ArrayList<>();
        for (UsersEO usersEO : usersEOS) {
            UserDTO user = new UserDTO();
            user.setUserId(usersEO.getUserId());
            user.setEmployeeId(usersEO.getEmployeeId());
            user.setFirstName(usersEO.getFirstName());
            user.setLastName(usersEO.getLastName());
            finalUsers.add(user);
        }
        return finalUsers;
    }

    /**
     * Domain method to Edit User
     *
     * @param user
     * @return
     */
    @Override
    public List<UserDTO> editUser(UserDTO user) {
        LOGGER.debug("editUser() method start" + user.toString());
        UsersEO usersEO = new UsersEO();
        usersEO.setUserId(user.getUserId());
        usersEO.setFirstName(user.getFirstName());
        usersEO.setLastName(user.getLastName());
        usersEO.setEmployeeId(user.getEmployeeId());
        usersRepository.saveAndFlush(usersEO);
        List<UserDTO> response = getUsers();
        LOGGER.debug("editUser() method end" + response.toString());
        return response;
    }

    /**
     * Domain Method to Fetch User
     *
     * @return
     */
    @Override
    public List<UserDTO> fetchUsers() {
        LOGGER.debug("fetchUsers() method start");
        List<UserDTO> response = getUsers();
        LOGGER.debug("fetchUsers() method end" + response.toString());
        return response;
    }

    /**
     * Domain method to Delete User
     *
     * @param user
     * @return
     */
    @Override
    public List<UserDTO> deleteUser(UserDTO user) {
        LOGGER.debug("deleteUser() method start" + user.toString());
        UsersEO usersEO = new UsersEO();
        usersEO.setUserId(user.getUserId());
        usersEO.setFirstName(user.getFirstName());
        usersEO.setLastName(user.getLastName());
        usersEO.setEmployeeId(user.getEmployeeId());
        usersRepository.delete(usersEO);
        List<UserDTO> response = getUsers();
        LOGGER.debug("deleteUser() method end" + response.toString());
        return response;
    }
}
