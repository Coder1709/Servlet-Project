package com.arpit.dao;

import com.arpit.model.User;

public interface UserDaoInterface {

    public void saveUser(User user);

    public User getUser(int id);

    public void updateUser(String valueToBeUpdate);

    public void deleteUser(int id);

}
