package org.fasttrackit;

import org.fasttrackit.domain.People;
import org.fasttrackit.persistance.PhoneBookRepository;
import org.fasttrackit.transfer.CreatePhoneBookRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        CreatePhoneBookRequest request = new CreatePhoneBookRequest();
        request.setFirstName("Laura");
        request.setLastName("Laco");
        request.setPhoneNumber(751224483);

        PhoneBookRepository phoneBookRepository = new PhoneBookRepository();
        phoneBookRepository.createContacts(request);

        List<People> people = phoneBookRepository.getPeople();
        System.out.println(people);

    }
}
