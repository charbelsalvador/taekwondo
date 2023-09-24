package com.taekwondo.Taekwondo.service;

import com.taekwondo.Taekwondo.models.ProductsTaekwondo;

import java.util.List;
import java.util.Optional;

public interface TaekwondoService {
    ProductsTaekwondo saved(ProductsTaekwondo productsTaekwondo);
    Optional<ProductsTaekwondo>findById(Long id);
    List<ProductsTaekwondo>findAll();
    Optional<ProductsTaekwondo>updateVersion(String version, Long id);
    Optional<ProductsTaekwondo>updateName(String name, Long id);
    Optional<ProductsTaekwondo>updateCreator(String creator, Long id);
}
