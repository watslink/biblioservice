package com.sd.oc.Service.ServiceInterface;

import com.sd.oc.model.User;

public interface UserService   {

    User getUserById(int id);

    void addUser(String username, String password, String mail);

    User getUserByUsername(String username);
}
