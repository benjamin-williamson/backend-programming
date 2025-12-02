package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Check if customers effectively don't exist (less than or equal to 1 to account for the sample one)
        if (customerRepository.count() < 2) {

            // We need a valid Division to save a customer.
            // Division ID 2 (usually 'New Jersey' or similar) should exist from your SQL script.
            Division division = divisionRepository.findById(2L).orElse(null);

            if (division != null) {
                Customer customer1 = new Customer();
                customer1.setFirstName("John");
                customer1.setLastName("Doe");
                customer1.setAddress("123 Elm St");
                customer1.setPostal_code("12345");
                customer1.setPhone("(555) 123-4567");
                customer1.setDivision(division);
                customer1.setCreate_date(new java.util.Date());
                customer1.setLast_update(new java.util.Date());

                Customer customer2 = new Customer();
                customer2.setFirstName("Jane");
                customer2.setLastName("Smith");
                customer2.setAddress("456 Oak Ave");
                customer2.setPostal_code("67890");
                customer2.setPhone("(555) 987-6543");
                customer2.setDivision(division);
                customer2.setCreate_date(new java.util.Date());
                customer2.setLast_update(new java.util.Date());

                Customer customer3 = new Customer();
                customer3.setFirstName("Michael");
                customer3.setLastName("Brown");
                customer3.setAddress("789 Pine Rd");
                customer3.setPostal_code("10112");
                customer3.setPhone("(555) 555-5555");
                customer3.setDivision(division);
                customer3.setCreate_date(new java.util.Date());
                customer3.setLast_update(new java.util.Date());

                Customer customer4 = new Customer();
                customer4.setFirstName("Emily");
                customer4.setLastName("Davis");
                customer4.setAddress("321 Maple Dr");
                customer4.setPostal_code("31415");
                customer4.setPhone("(555) 111-2222");
                customer4.setDivision(division);
                customer4.setCreate_date(new java.util.Date());
                customer4.setLast_update(new java.util.Date());

                Customer customer5 = new Customer();
                customer5.setFirstName("David");
                customer5.setLastName("Wilson");
                customer5.setAddress("654 Cedar Ln");
                customer5.setPostal_code("92653");
                customer5.setPhone("(555) 333-4444");
                customer5.setDivision(division);
                customer5.setCreate_date(new java.util.Date());
                customer5.setLast_update(new java.util.Date());

                customerRepository.save(customer1);
                customerRepository.save(customer2);
                customerRepository.save(customer3);
                customerRepository.save(customer4);
                customerRepository.save(customer5);

                System.out.println("Sample customers added!");
            } else {
                System.out.println("Could not add sample customers: Division ID 2 not found.");
            }
        }
    }
}