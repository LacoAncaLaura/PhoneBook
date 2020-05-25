package org.fasttrackit.web;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.service.PeopleService;
import org.fasttrackit.transfer.CreatePhoneBookRequest;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/people1")
public class PeopleServlet extends HttpServlet {
    private PeopleService peopleService = new PeopleService();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        CreatePhoneBookRequest request = objectMapper.readValue(req.getReader(), CreatePhoneBookRequest.class);

        try {
            peopleService.createContact(request);
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "There was an error while processing your request." + e.getMessage());
        }
    }
}