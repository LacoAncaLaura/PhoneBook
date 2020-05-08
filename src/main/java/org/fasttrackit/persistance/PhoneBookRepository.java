package org.fasttrackit.persistance;

import org.fasttrackit.transfer.CreatePhoneBookRequest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PhoneBookRepository {
    public void createContacts(CreatePhoneBookRequest request) throws IOException, SQLException {
        String sql = "INSERT INTO people (firstName,lastNme,phoneNumber) VALUES(?,?,?)";
        try(Connection connection = DataBaseConfiguration.getConnection()){
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, request.getFirstName());
            preparedStatement.setString(2, request.getLastName());
            preparedStatement.setLong(3, request.getPhoneNumber());
            preparedStatement.executeUpdate();
        }
//        String sql1 = "SELECT * FROM phone_book.people";
//        String sql2 = "SELECT first_name FROM phone_book.people";
//        String sql3 = "UPDATE people SET first_name = 'Anca' WHERE first_name = 'Laura'";
//        String sql4 = "DELETE FROM people WHERE last_name = 'Laco' ";
        //String sql5 = "DELETE * FROM phone_book.people;



    }
}
