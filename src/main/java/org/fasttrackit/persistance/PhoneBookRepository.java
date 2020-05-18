package org.fasttrackit.persistance;

import org.fasttrackit.UpdatePhoneBookRepositary;
import org.fasttrackit.domain.People;
import org.fasttrackit.transfer.CreatePhoneBookRequest;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookRepository {
    public void createContacts( CreatePhoneBookRequest request) throws IOException, SQLException {
        String sql = "INSERT INTO people (FistName,LastName,PhoneNumber) VALUES(?,?,?)";
        try (Connection connection = DataBaseConfiguration.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, request.getFirstName());
            preparedStatement.setString(2, request.getLastName());
            preparedStatement.setLong(3, request.getPhoneNumber());
            preparedStatement.executeUpdate();
        }
    }
    public List<People> getPeople() throws IOException,SQLException, ClassNotFoundException{
    String sql1 = "SELECT * FROM people";
    List<People> phoneNumbers = new ArrayList<>();
        try (Connection connection = DataBaseConfiguration.getConnection();
             Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery(sql1);

            while (resultSet.next()) {
                People people = new People();
                people.setId(resultSet.getLong("id"));
                people.setFirstName(resultSet.getString("Laura"));
                people.setLastName(resultSet.getString("Laco");
                people.setPhoneNumber(resultSet.getLong(751224483));
                phoneNumbers.add(people);

            }
            return phoneNumbers;
        }

    }public void updatePeople (long id, UpdatePhoneBookRequest request) throws   SQLException, IOException, ClassNotFoundException {
        String sql4 = " UPDATE People SET first_name = ? WHERE id = ?";
        try (Connection connection = DataBaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql4)) {
            preparedStatement.setBoolean(1, request.));
            preparedStatement.setLong(2, id);

            preparedStatement.executeUpdate();
        }
    }

//        String sql3 = "UPDATE people SET first_name = 'Anca' WHERE first_name = 'Laura'";
//        String sql4 = "DELETE FROM people WHERE last_name = 'Laco' ";
    //String sql5 = "DELETE * FROM phone_book.people;

}

