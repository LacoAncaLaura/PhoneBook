package org.fasttrackit.persistance;

import org.fasttrackit.domain.People;
import org.fasttrackit.transfer.CreatePhoneBookRequest;
import org.fasttrackit.transfer.UpdatePhoneBookRequest;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookRepository {
    public void createContacts(CreatePhoneBookRequest request) throws IOException, SQLException {
        String sql = "INSERT INTO people(FirstName,LastName,PhoneNumber) VALUES(?,?,?)";
        try (Connection connection = DataBaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, request.getFirstName());
            preparedStatement.setString(2, request.getLastName());
            preparedStatement.setLong(3, request.getPhoneNumber());
            preparedStatement.executeUpdate();
        }
    }

    public List<People> getPeople1() throws IOException, SQLException, ClassNotFoundException {
        String sql1 = "SELECT * FROM people";
        List<People> PhoneNumbers = new ArrayList<>();
        try (Connection connection = DataBaseConfiguration.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql1);

            while (resultSet.next()) {
                People people = new People();
                people.setId(resultSet.getLong("id"));
                people.setFirstName(resultSet.getString("FistName"));
                people.setLastName(resultSet.getString("LastName"));
                people.setPhoneNumber(resultSet.getLong("PhoneNumber"));PhoneNumbers.add(people);

            }
            return PhoneNumbers;
        }

    }

    public void updatePeople(long id, UpdatePhoneBookRequest request) throws SQLException, IOException, ClassNotFoundException {
        String sql4 = "UPDATE People SET FirstName = ?, LastName = ?, PhoneNumber = ? WHERE id = ?";
        try (Connection connection = DataBaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql4)) {
            preparedStatement.setString(1, request.getFirstName());
            preparedStatement.setString(1, request.getLastName());
            preparedStatement.setLong(2, request.getPhoneNumber());
            preparedStatement.setLong(2, id);

            preparedStatement.executeUpdate();
        }
    }

    public void deleteContact(long PhoneNumber) throws SQLException, IOException, ClassNotFoundException {
        String sql5 = "DELETE FROM people WHERE PhoneNumber =?";
        try (Connection connection = DataBaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql5)) {
            preparedStatement.setLong(1, PhoneNumber);
            preparedStatement.executeUpdate();
        }
    }


//    public void deleteAll(long id) throws SQLException, IOException, ClassNotFoundException {
//        String sql6 = "DELETE * FROM people";
//        try (Connection connection = DataBaseConfiguration.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql6)) {
//            preparedStatement.setLong(1, id);
//            preparedStatement.executeUpdate();
//        }
//    }
}






