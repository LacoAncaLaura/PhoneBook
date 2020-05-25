package org.fasttrackit.web;


import org.fasttrackit.service.PeopleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PhoneBook")
public class PeopleServlet extends HttpServlet {
    private PeopleService peopleService = new PeopleService();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException {

    }
}
