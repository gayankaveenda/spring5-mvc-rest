package guru.springfamework.services;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.mapper.CustomerMapper;
import guru.springfamework.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream().
                map(customer -> customerMapper.customerToCustomerDTO(customer)).
                collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customerMapper.customerToCustomerDTO(customer.get());
    }

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        Customer customer =
                customerRepository.save(customerMapper.customerDTOToCustomer(customerDTO));
        customer.setCustomerUrl("/api/v1/customers/" + customer.getId());

        return customerMapper.customerToCustomerDTO(customerRepository.saveAndFlush(customer));
    }

    @Override
    public CustomerDTO update(Long id, CustomerDTO customerDTO) {
        Optional<Customer> customer = customerRepository.findById(id);
         customer.ifPresent(c -> {
             c.setFirstName(customerDTO.getFirstname());
             c.setLastName(customerDTO.getLastname());

            customerRepository.saveAndFlush(c);
         });

        return customerMapper.customerToCustomerDTO(customer.get());
    }
}
