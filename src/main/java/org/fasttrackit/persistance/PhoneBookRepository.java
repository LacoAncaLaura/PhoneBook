package org.fasttrackit.persistance;

import org.fasttrackit.transfer.CreatePhoneBookRequest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PhoneBookRepository {
    public void createContacts(CreatePhoneBookRequest request) throws IOException, SQLException {
        String sql = "INSERT INTO people (firstName,lastNme,phoneNumber) VALUES(?,?)";
        try(Connection connection = DataBaseConfiguration.getConnection()){
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, request.getFirstName());
            preparedStatement.setString(2, request.getLastName());
            preparedStatement.setLong(1, request.getPhoneNumber());
            preparedStatement.executeUpdate();
        }



    }
}
