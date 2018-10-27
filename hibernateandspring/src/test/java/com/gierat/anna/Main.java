package com.gierat.anna;

import com.gierat.anna.configuration.AppAutoConfiguration;
import com.gierat.anna.configuration.AppConfiguration;
import com.gierat.anna.model.Customer;
import com.gierat.anna.model.CustomerB2B;
import com.gierat.anna.services.ICustomerService;
import com.gierat.anna.services.ICustomerServiceB2B;
import com.gierat.anna.services.impl.CustomerService;
import com.gierat.anna.services.impl.CustomerServiceB2B;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppAutoConfiguration.class);
        ICustomerService customerService = context.getBean(ICustomerService.class);
        ICustomerServiceB2B customerServiceB2B = context.getBean(ICustomerServiceB2B.class);


        Customer customer = new Customer();
        customer.setName("Jan");
        customer.setSurname("Kowalski");
        customer.setPhone("123456789");

        customerService.saveCustomer(customer);

        Customer customerFromDB = customerService.getCustomerById(1);
        System.out.println(customerFromDB);


        CustomerB2B customerB2B = new CustomerB2B();
        customerB2B.setCompanyName("Biedronka");
        customerB2B.setFax("123456789");
        customerB2B.setNip("123456789");
        customerB2B.setFax("123456789");

        customerServiceB2B.saveCustomer(customerB2B);

        CustomerB2B customerB2BFromDB = customerServiceB2B.getCustomerById(1);
        System.out.println(customerB2BFromDB);

        System.exit(0);
    }
}
