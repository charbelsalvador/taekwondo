package com.taekwondo.Taekwondo.repository;

import com.taekwondo.Taekwondo.models.ProductsTaekwondo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaekwondoRepository extends JpaRepository<ProductsTaekwondo, Long> {
}
