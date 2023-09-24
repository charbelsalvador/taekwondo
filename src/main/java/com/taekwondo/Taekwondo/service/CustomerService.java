package com.taekwondo.Taekwondo.service;

import com.taekwondo.Taekwondo.models.CustomerTaekwondo;
import com.taekwondo.Taekwondo.models.ProductsTaekwondo;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    CustomerTaekwondo create(String name, ProductsTaekwondo productsTaekwondo);
    Optional<CustomerTaekwondo>findById(Long id);
    List<CustomerTaekwondo>findAll();
    void delete(Long id);
    Optional<CustomerTaekwondo>updateName(Long id, String name, ProductsTaekwondo productsTaekwondo);
}
