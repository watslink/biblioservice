package com.sd.oc.API;

import com.sd.oc.Service.ServiceInterface.UserService;
import com.sd.oc.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "UserAPI")
public class UserServiceAPI {

    ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationAPI.class);

    UserService userService = context.getBean(UserService.class);

    @WebMethod(operationName = "findUserById")
    public User findUserById(@WebParam(name = "user_id") int id) {
        User user = userService.getUser(id);
        return user;
    }


}
