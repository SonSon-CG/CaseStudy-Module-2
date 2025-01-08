package model;

import exception.InvalidDataException;

import java.util.regex.Pattern;

public class Customer {
    private int id;
    private String name;
    private String email;
    private String phone;

    private static final String EMAIL_REGEX = "^[\\w-\\.]+@[\\w-\\.]+\\.[a-zA-Z]{2,7}$";
    private static final String PHONE_REGEX = "^\\d{10,15}$";

    public Customer(int id, String name, String email, String phone) throws InvalidDataException {
        if (!Pattern.matches(EMAIL_REGEX, email)) {
            throw new InvalidDataException("Email không hợp lệ: " + email);
        }
        if (!Pattern.matches(PHONE_REGEX, phone)) {
            throw new InvalidDataException("Số điện thoại không hợp lệ: " + phone);
        }
    }
}