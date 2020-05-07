package org.fasttrackit.domain;

public class people {
    private long id;
    private String firstName;

    @Override
    public String toString() {
        return "people{" +
                "id=" + id +
                ", FirstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", PhoneNumber=" + phoneNumber +
                '}';
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        firstName = firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        lastName = lastName;
    }

    public long getphoneNumber() {
        return phoneNumber;
    }

    public void setphoneNumber(long phoneNumber) {
        phoneNumber = phoneNumber;
    }

    private String lastName;
    private long phoneNumber;


}
