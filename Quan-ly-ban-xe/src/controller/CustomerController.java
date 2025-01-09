package controller;

import exception.CustomerNotFoundException;
import exception.DuplicateCustomerException;
import model.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerController {
    private Map<Integer, Customer> customerMap = new HashMap<>();

    public void addCustomer(Customer customer) throws DuplicateCustomerException {
        for (Customer existingCustomer : customerMap.values()) {
            if (existingCustomer.equals(customer)) {
                throw new DuplicateCustomerException("Khách hàng đã tồn tại với số điện thoại này!");
            }
        }
        customerMap.put(customer.getId(), customer);
    }

    public Customer getCustomerById(int id) throws CustomerNotFoundException {
        if (!customerMap.containsKey(id)) {
            throw new CustomerNotFoundException("Không tìm thấy khách hàng với ID: " + id);
        }
        return customerMap.get(id);
    }

    public void displayCustomers() {
        if (customerMap.isEmpty()) {
            System.out.println("Danh sách khách hàng trống.");
        } else {
            customerMap.values().forEach(System.out::println);
        }
    }
}
