package DataBean;

import javax.persistence.Column;

public class ClientBean {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;

    public ClientBean setId(final int id) {
        this.id = id;
        return this;
    }

    public ClientBean setFirstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ClientBean setLastName(final String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ClientBean setAddress(final String address) {
        this.address = address;
        return this;
    }

    public ClientBean setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }


    public int getId() {

        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
