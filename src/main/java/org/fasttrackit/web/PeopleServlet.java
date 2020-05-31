package org.fasttrackit.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.ObjectMapperConfiguration;
import org.fasttrackit.domain.People;
import org.fasttrackit.service.PeopleService;
import org.fasttrackit.transfer.CreatePhoneBookRequest;
import org.fasttrackit.transfer.UpdatePhoneBookRequest;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/people1")
public class PeopleServlet extends HttpServlet {
    private PeopleService peopleService = new PeopleService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CreatePhoneBookRequest request = ObjectMapperConfiguration.OBJECT_MAPPER.readValue(req.getReader(), CreatePhoneBookRequest.class);

        try {
            peopleService.createContact(request);
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "There was an error while processing your request." + e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        UpdatePhoneBookRequest request = ObjectMapperConfiguration.OBJECT_MAPPER.readValue(req.getReader(), UpdatePhoneBookRequest.class);
        try {
            peopleService.updatePeople(Long.parseLong(id),request);
        }  catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "There was an error while processing your request." + e.getMessage());
        }
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try {
            peopleService.deleteContact(Long.parseLong(id));

        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "There was an error while processing your request." + e.getMessage());
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            List<People> people1 = peopleService.getPeople1();

            ObjectMapperConfiguration.OBJECT_MAPPER.writeValue(resp.getWriter(),people1);

        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "There was an error while processing your request." + e.getMessage());
        }
    }
}
