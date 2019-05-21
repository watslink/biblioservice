package com.sd.oc.Service.ServiceInterface;

import com.sd.oc.model.User;

public interface UserService {

    User getUser(int id);

    User checkUserConnection(String username, String password);
}
