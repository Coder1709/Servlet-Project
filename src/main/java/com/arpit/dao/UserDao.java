package com.arpit.dao;

import com.arpit.dao.UserDaoInterface;
import com.arpit.model.User;
import com.arpit.utils.ConUtils;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements UserDaoInterface {
    @Override
    public void saveUser(User user) {

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        connection = ConUtils.getInstance().getConnection();
        if (connection == null) {
            System.out.println("Connection is null");
            return;
        }
        String query = "INSERT INTO users (name, email, country) VALUES (?, ?, ?)";
        System.out.println("Connection Created Successfully");
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            int c = preparedStatement.executeUpdate();
            System.out.println(c);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public User getUser(int id) {
        User user =null;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        connection = ConUtils.getInstance().getConnection();
        if (connection == null) {
            System.out.println("Connection is null");
            return null;
        }
        String query = "SELECT * FROM users WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public void updateUser(String valueToBeUpdate) {

    }

    @Override
    public void deleteUser(int id) {

    }
}
