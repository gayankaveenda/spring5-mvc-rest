package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jt on 9/24/17.
 */
@Component
@AllArgsConstructor
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;


    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadCustomers();
    }

    private void loadCustomers() {
        Customer customer1 = new Customer();
        customer1.setId(1l);
        customer1.setFirstName("Jay");
        customer1.setLastName("Arthus");
        customer1.setCustomerUrl("/api/v1/customers/1");

        Customer customer2 = new Customer();
        customer2.setId(2l);
        customer2.setFirstName("Mark");
        customer2.setLastName("matias");
        customer2.setCustomerUrl("/api/v1/customers/2");

        Customer customer3 = new Customer();
        customer3.setId(3l);
        customer3.setFirstName("Jasmine");
        customer3.setLastName("Parker");
        customer3.setCustomerUrl("/api/v1/customers/3");

        Customer customer4 = new Customer();
        customer4.setId(4l);
        customer4.setFirstName("Nadia");
        customer4.setLastName("Styles");
        customer4.setCustomerUrl("/api/v1/customers/4");

        List<Customer> customers = Arrays.asList(customer1, customer2,
                customer3, customer4);

        customerRepository.saveAll(customers);

        System.out.println("Data Loaded = " + customerRepository.count());
    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Data Loaded = " + categoryRepository.count());
    }
}