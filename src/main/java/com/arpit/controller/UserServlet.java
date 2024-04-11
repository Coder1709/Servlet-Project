package com.arpit.controller;


import com.arpit.dao.UserDao;
import com.arpit.model.User;
import com.arpit.model.factory.UserFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserDao userDao;


    @Override
    public void init() throws ServletException {
        userDao = new UserDao();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("UserServlet.service");

        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String name = firstname+ " " + lastname;
        String email = req.getParameter("email");
        String country = req.getParameter("country");

        User user = UserFactory.createUser( name, email, country);


        System.out.println(user);

        req.setAttribute("user", user);
        req.setAttribute("message", "User created successfully");
        req.setAttribute("name" , name);
        req.setAttribute("email" , email);
        req.setAttribute("country" , country);

        userDao.saveUser(user);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req, resp);



    }
}
