package org.fasttrackit.service;

import com.sun.org.apache.bcel.internal.generic.Select;
import org.fasttrackit.domain.People;
import org.fasttrackit.persistance.DataBaseConfiguration;
import org.fasttrackit.persistance.PhoneBookRepository;
import org.fasttrackit.transfer.CreatePhoneBookRequest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PeopleService {
    private PhoneBookRepository phoneBookRepository = new PhoneBookRepository();

    public void createContact(CreatePhoneBookRequest request) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Creating contact: " + request);
        phoneBookRepository.createContacts(request);
    }

    public List<People> selectContact() throws SQLException, IOException {
        String sql3 = "SELECT fistName FROM people WHERE fistName = Laura ";
        List<People> phoneNumbers = new ArrayList<>();
        try (Connection connection = DataBaseConfiguration.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql3);
        }
        return selectContact();
    }

}