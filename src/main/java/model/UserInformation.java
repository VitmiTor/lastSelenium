package model;

import com.github.javafaker.Faker;

public class UserInformation {
    private final String userName;
    private final String email;
    private final String password;

    public UserInformation() {
        var faker = new Faker();
        userName = faker.name().firstName();
        email = faker.internet().emailAddress();
        password = faker.internet().password();
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
