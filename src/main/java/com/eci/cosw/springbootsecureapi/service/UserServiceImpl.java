package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@Service
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();


    @Autowired
    public UserServiceImpl()
    {
    }

    @PostConstruct
    private void populateSampleData()
    {
        users.add( new User( "test@mail.com", "password", "Andres", "Perez" ) );
    }


    @Override
    public List<User> getUsers()
    {
        return users;
    }

    @Override
    public User getUser( int id ) {
        return users.get(id);
    }

    @Override
    public User createUser( User user ) {
        boolean existe = false;
        for (User i: users){
            if (i.getEmail().equals(user.getEmail())){
                existe = true;
            }
        }
        if(!existe){
            users.add(user);
            return users.get(users.size()-1);
        }
        else{
            return null;
        }

    }

    @Override
    public User findUserByEmail( String email )
    {
        for(User i:users){
            if (i.getEmail().equals(email)){
                return i;
            }
        }
        return null;
    }

    @Override
    public User findUserByEmailAndPassword( String email, String password ) {
        for(User i:users){
            if (i.getEmail().equals(email) && i.getPassword().equals(password)){
                return i;
            }
        }
        return null;
    }

}
