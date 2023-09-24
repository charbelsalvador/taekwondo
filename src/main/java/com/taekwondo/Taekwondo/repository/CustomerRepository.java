package com.taekwondo.Taekwondo.repository;

import com.taekwondo.Taekwondo.models.CustomerTaekwondo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerTaekwondo, Long> {
}
