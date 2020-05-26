package org.fasttrackit.service;
import org.fasttrackit.domain.People;
import org.fasttrackit.persistance.PhoneBookRepository;
import org.fasttrackit.transfer.CreatePhoneBookRequest;
import org.fasttrackit.transfer.UpdatePhoneBookRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class PeopleService {
    private PhoneBookRepository phoneBookRepository = new PhoneBookRepository();

    public void createContact(CreatePhoneBookRequest request) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Creating contact: " + request);
        phoneBookRepository.createContacts(request);
    }

    public void updatePeople(long id, UpdatePhoneBookRequest request) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Updating task: " + id + ":" + request);
        phoneBookRepository.updatePeople(id, request);
    }

    public void deleteContact(long id) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Deleting task: " + id);
        phoneBookRepository.deleteContact(id);
    }

    public List<People> getPeople1() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Retrieving tasks");
        phoneBookRepository.getPeople1();
        return getPeople1();
    }
//    public void deleteAll(long id)throws SQLException, IOException, ClassNotFoundException {
//        System.out.println("Deleting all");
//        phoneBookRepository.deleteAll(id);
//    }

}