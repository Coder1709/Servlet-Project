package com.arpit.model.factory;

import com.arpit.model.User;

public class UserFactory {

    public static User createUser( String name, String email, String country) {
        return new User( name, email, country);
    }

}
