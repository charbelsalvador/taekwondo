package com.taekwondo.Taekwondo.service;

import com.taekwondo.Taekwondo.models.ProductsTaekwondo;
import com.taekwondo.Taekwondo.repository.TaekwondoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaekwondoServiceImpl implements TaekwondoService{

    private final TaekwondoRepository taekwondoRepository;

    public TaekwondoServiceImpl(TaekwondoRepository taekwondoRepository) {
        this.taekwondoRepository = taekwondoRepository;
    }

    @Override
    public ProductsTaekwondo saved(ProductsTaekwondo productsTaekwondo) {
        ProductsTaekwondo productsTaekwondoSaved = this.taekwondoRepository.save(productsTaekwondo);
        return productsTaekwondoSaved;
    }

    @Override
    public Optional<ProductsTaekwondo> findById(Long id) {
        return this.taekwondoRepository.findById(id);
    }

    @Override
    public List<ProductsTaekwondo> findAll() {
        return this.taekwondoRepository.findAll();
    }

    @Override
    public Optional<ProductsTaekwondo> updateVersion(String version, Long id) {
        Optional<ProductsTaekwondo>productsTaekwondo = this.taekwondoRepository.findById(id);

        if (productsTaekwondo.isPresent()){
            ProductsTaekwondo productsTaekwondoSave = productsTaekwondo.get();
            productsTaekwondoSave.setVersion(version);
            return Optional.of(this.taekwondoRepository.save(productsTaekwondoSave));
        }
        return Optional.empty();
    }

    @Override
    public Optional<ProductsTaekwondo> updateName(String name, Long id) {
        Optional<ProductsTaekwondo>productsTaekwondo=this.taekwondoRepository.findById(id);

        if (productsTaekwondo.isPresent()){
            ProductsTaekwondo productsTaekwondoSave = productsTaekwondo.get();
            productsTaekwondoSave.setName(name);
            return Optional.of(this.taekwondoRepository.save(productsTaekwondoSave));
        }
        return Optional.empty();
    }

    @Override
    public Optional<ProductsTaekwondo> updateCreator(String creator, Long id) {
        Optional<ProductsTaekwondo>productsTaekwondo = this.taekwondoRepository.findById(id);

        if (productsTaekwondo.isPresent()){
            ProductsTaekwondo productsTaekwondoSave = productsTaekwondo.get();
            productsTaekwondoSave.setCreator(creator);
            return Optional.of(this.taekwondoRepository.save(productsTaekwondoSave));
        }
        return Optional.empty();
    }
}
