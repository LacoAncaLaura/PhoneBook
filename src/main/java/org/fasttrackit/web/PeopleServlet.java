package org.fasttrackit.web;


import org.fasttrackit.service.PeopleService;

public class PeopleServlet extends HttpServlet{
    private PeopleService peopleService = new PeopleService();

    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException{

    }
}
