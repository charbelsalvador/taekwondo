package com.taekwondo.Taekwondo.service;

import com.taekwondo.Taekwondo.models.CustomerTaekwondo;
import com.taekwondo.Taekwondo.models.ProductsTaekwondo;
import com.taekwondo.Taekwondo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerTaekwondo create(String name, ProductsTaekwondo productsTaekwondo) {
        CustomerTaekwondo customerSaved= new CustomerTaekwondo();
        customerSaved.setName(name);
        customerSaved.setProductsTaekwondo(productsTaekwondo);
        return customerRepository.save(customerSaved);
    }

    @Override
    public Optional<CustomerTaekwondo> findById(Long id) {
        return this.customerRepository.findById(id);
    }

    @Override
    public List<CustomerTaekwondo> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public Optional<CustomerTaekwondo> updateName(Long id, String name, ProductsTaekwondo productsTaekwondo) {
        Optional<CustomerTaekwondo>customerUpdateName = this.customerRepository.findById(id);
        if (customerUpdateName.isPresent()){
            CustomerTaekwondo customerTaekwondo = customerUpdateName.get();
            customerTaekwondo.setName(name);
            customerTaekwondo.setProductsTaekwondo(productsTaekwondo);
            return Optional.of(this.customerRepository.save(customerTaekwondo));
        }
        return Optional.empty();
    }
}
