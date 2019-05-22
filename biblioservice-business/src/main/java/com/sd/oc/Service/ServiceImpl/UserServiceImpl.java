package com.sd.oc.Service.ServiceImpl;


import com.sd.oc.DAO.UserDAO;
import com.sd.oc.Service.ServiceInterface.UserService;
import com.sd.oc.model.MyUserDetails;
import com.sd.oc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    private PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @Override
    public User getUser(int id) {
        Optional<User> optUser=userDAO.findById(id);
        return optUser.orElse(null);
    }


    @Override
    public void addUser(String username, String password, String mail) {
        User user=new User(username, passwordEncoder.encode(password), mail);
        userDAO.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserDetails(user);
    }
}
