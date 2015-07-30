package com.example.administrador.myapplication.model.persistence;

import com.example.administrador.myapplication.model.entities.Client;
import com.example.administrador.myapplication.model.entities.User;

import java.util.List;

/**
 * Created by Administrador on 30/07/2015.
 */
public interface UserRepository {
    public void save(User user);
    public List<User> authentication(User user);
    public List<User> getAll();
}
