package guru.springfamework.services;

import guru.springfamework.api.v1.model.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(Long id);

    CustomerDTO create(CustomerDTO customerDTO);

    CustomerDTO update(Long id, CustomerDTO customerDTO);
}
